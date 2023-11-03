package br.cefetmg.lagos.model.dao.util;

import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.Manager;
import br.cefetmg.lagos.model.dto.exceptions.DTOExeption;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DTODb<DataTransferObject extends DTO<DataTransferObject>> {
    private final DataTransferObject dto;
    private final Manager manager;

    private final Map<String, Methods> getters;
    private final Map<String, Methods> setters;

    public DTODb(DataTransferObject dto) {
        this.dto = dto;
        manager = dto.getManeger();
        getters = initGetters();
        setters = initSetters();
    }

    private static class Methods {
        public Method dto;
        public Method db;

        public Methods(Method dto, Method db) {
            this.dto = dto;
            this.db = db;
        }

        @Override
        public String toString() {
            return "(dto: " + dto.getName() + ", db: " + db.getName() + ")";
        }
    }

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static Method getDbMethodForLeak(Class<? extends Annotation> leak, Method dtoMethod)
            throws NoSuchMethodException {
        if (leak == Setter.class) {
            Class<?> tipo = dtoMethod.getParameterTypes()[0];
            return ResultSet.class.getMethod("get" + capitalize(tipo.getSimpleName()), String.class);
        } else {
            Class<?> tipo = dtoMethod.getReturnType();
            return PreparedStatement.class.getMethod("set" + capitalize(tipo.getSimpleName()), int.class, tipo);
        }
    }

    private Map<String, Methods> getMethods(Map<String, Method> dtoMethods, Class<? extends Annotation> leak) {
        Map<String, Methods> methodsMap = dtoMethods.keySet().stream()
                .map(column -> {
                    Method method = dtoMethods.get(column);
                    try {
                        return Map.entry(column, new Methods(method, getDbMethodForLeak(leak, method)));
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return new TreeMap<>(methodsMap);
    }

    private Map<String, Methods> initGetters() {
        return getMethods(manager.getGetters(), Getter.class);
    }

    private Map<String, Methods> initSetters() {
        return getMethods(manager.getSetters(), Setter.class);
    }

    private static List<Map.Entry<String, Methods>> getMethodsForColumns(Map<String, Methods> methods, List<String> columns) {
        return columns.stream()
                .map(column -> Map.entry(column, methods.get(column)))
                .toList();
    }

    private List<Map.Entry<String, Methods>> getGettersForColumns(List<String> columns) {
        return getMethodsForColumns(getters, columns);
    }

    private List<Map.Entry<String, Methods>> getSettersForColumns(List<String> columns) {
        return getMethodsForColumns(setters, columns);
    }

    public int setPreparedStatement(DataTransferObject dto, PreparedStatement preparedStatement, List<String> columns, int initial) {
        AtomicInteger i = new AtomicInteger(initial);
        getGettersForColumns(columns).forEach(entry -> {
            Methods methods = entry.getValue();
            try {
                methods.db.invoke(preparedStatement, i.getAndIncrement(), methods.dto.invoke(dto));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
        return i.get();
    }

    public int setPreparedStatement(DataTransferObject dto, PreparedStatement preparedStatement, List<String> columns) {
        return setPreparedStatement(dto, preparedStatement, columns, 1);
    }

    public DataTransferObject insertInto(DataTransferObject dto, ResultSet resultSet, List<String> columns) {
        getSettersForColumns(columns).forEach(entry -> {
            String column = entry.getKey();
            Methods methods = entry.getValue();
            try {
                methods.dto.invoke(dto, methods.db.invoke(resultSet, column));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });

        return dto;
    }

    public DataTransferObject createWith(ResultSet resultSet, List<String> columns) throws DTOExeption {
        return insertInto(dto.getInstance(), resultSet, columns);
    }
}
