package br.cefetmg.lagos.model.dto.base;

import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class Manager {
    private final Class<? extends DTO> dtoClass;
    private final DTO dto;
    private final Map<String, Method> getters;
    private final Map<String, Method> setters;
    private final List<String> columns;

    private static String getColumnNameFrom(Method method) {
        return method.getAnnotation(Column.class).nome();
    }

    private Map<String, Method> getMethodsFromDTO(Class<? extends Annotation> leak) {
        Map<String, Method> methodsMap = Arrays.stream(dtoClass.getMethods())
                .filter(method -> method.isAnnotationPresent(Column.class)
                        && method.isAnnotationPresent(leak)
                )
                .map(method -> Map.entry(getColumnNameFrom(method), method))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return new TreeMap<>(methodsMap);
    }

    public Manager(DTO dto, Class<? extends DTO> dtoClass) {
        this.dto = dto;
        this.dtoClass = dtoClass;
        getters = initGetters();
        setters = initSetters();
        columns = initColumns();
    }

    public Manager(DTO dto) {
        this(dto, dto.getClass());
    }

    private Map<String, Method> initGetters() {
        return getMethodsFromDTO(Getter.class);
    }

    public Map<String, Method> getGetters() {
        return getters;
    }

    private Map<String, Method> initSetters() {
        return getMethodsFromDTO(Setter.class);
    }

    public Map<String, Method> getSetters() {
        return setters;
    }

    private List<String> initColumns() {
        return new ArrayList<>(getGetters().keySet().stream().sorted().toList());
    }

    public List<String> getColumns() {
        return columns;
    }

    public String getPKColumn() {
        return "pk";
    }

    public List<String> getColumnsButPK() {
        List<String> c = new ArrayList<>(getColumns());
        c.remove(getPKColumn());
        return c;
    }

    private static List<Map.Entry<String, Method>> getMethodsGroupedByColumns(Map<String, Method> methods, List<String> columns) {
        return columns.stream()
                .map(column -> Map.entry(column, methods.get(column)))
                .toList();
    }

    private Object getColumn(String column) throws InvocationTargetException, IllegalAccessException {
        Object getResult = getGetters().get(column).invoke(dto);
        if (getResult == null)
            getResult = "null";
        return getResult;
    }

    private Map.Entry<String, Object> columnValue(String column) {
        try {
            return Map.entry(column, getColumn(column));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public String toString() {
        return toMap().entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(", ", "{", "}"));
    }

    public Map<String, Object> toMap() {
        return getColumns().stream()
                .map(this::columnValue)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
