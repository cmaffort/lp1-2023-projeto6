package br.cefetmg.lagos.model.util;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.loja.base.IManterLojaModule;
import br.cefetmg.lagos.util.Pair;
import com.google.gson.Gson;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.XML;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.time.LocalDateTime;
import java.util.*;

public class DataBaseParser {
    private static final List<IManterLojaModule<? extends DTO>> services;

    static {
        Logger.getRootLogger().setLevel(Level.OFF);
        services = getAllLojaServices();
    }

    private static List<IManterLojaModule<? extends DTO>> getAllLojaServices() {
        Reflections reflections = new Reflections("br.cefetmg.lagos.model.service.loja");
        List<Class<? extends IManterLojaModule>> servicesClasses = reflections.getSubTypesOf(IManterLojaModule.class).stream()
                .filter(clss -> !clss.isInterface() && !Modifier.isAbstract(clss.getModifiers())).toList();
        List<IManterLojaModule<? extends DTO>> servicesLoja = new ArrayList<>();

        for (Class<?> dtoLojaClass : servicesClasses) {
            try {
                IManterLojaModule<? extends DTO> service =
                        (IManterLojaModule<? extends DTO<?>>) dtoLojaClass.getDeclaredConstructor().newInstance();
                servicesLoja.add(service);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }

        return servicesLoja;
    }

    private static TreeMap<String, List<TreeMap<String, List<TreeMap<String, Object>>>>> lojaDbToMap(Loja loja) {
        if (loja == null || loja.getId() == null)
            return new TreeMap<>();

        return new TreeMap<>(Map.ofEntries(
                Map.entry("loja_db", services.stream()
                        .map(service -> {
                            try {
                                return tableMap(service.pesquisarPorLoja(loja));
                            } catch (NegocioException | PersistenceException e) {
                                throw new RuntimeException(e.getMessage(), e);
                            }
                        })
                        .toList())
        ));
    }

    private static TreeMap<String, List<TreeMap<String, Object>>> tableMap(List<? extends DTO<?>> dtos) {
        if (dtos.isEmpty())
            return new TreeMap<>();
        return new TreeMap<>(Map.ofEntries(
                Map.entry(dtos.get(0).getManeger().getTable(), dtos.stream().map(dto -> dto.toMap().entrySet().stream()
                                .map(entry -> {
                                    if (entry.getValue() == null)
                                        return new Pair<>(entry.getKey(), "null");
                                    if (entry.getValue().getClass() == LocalDateTime.class)
                                        return new Pair<>(entry.getKey(), entry.getValue().toString());
                                    return new Pair<>(entry.getKey(), entry.getValue());
                                })
                                .collect(TreeMap<String, Object>::new, (map, pair) -> map.put(pair.first(), pair.second()), TreeMap::putAll)
                ).toList())
        ));
    }

    public static String dbLojaToJSON(Loja loja) {
        Gson gson = new Gson();
        return gson.toJson(lojaDbToMap(loja));
    }

    public static String dbLojaToXML(Loja loja) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + XML.toString(new JSONObject(dbLojaToJSON(loja)));
    }
}
