package br.cefetmg.lagos.model.dto.base;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.util.Pair;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class Manager<DataTransferObject extends DTO<DataTransferObject>> {
    private final Class<DataTransferObject> dtoClass;
    private final DataTransferObject dto;

    private final Map<String, Method> getters;
    private final Map<String, Method> setters;
    private final List<String> columns;

    private final Map<String, Method> getterRelated;
    private final Map<String, Method> setterRelated;

    private static String getRelatedNameFrom(Method method) {
        return method.getAnnotation(Related.class).nome();
    }

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

    private Map<String, Method> getRelatedMethodsFromDTO(Class<? extends Annotation> leak) {
        Map<String, Method> methodsMap = Arrays.stream(dtoClass.getMethods())
                .filter(method -> method.isAnnotationPresent(Related.class)
                        && method.isAnnotationPresent(leak))
                .map(method -> Map.entry(getRelatedNameFrom(method), method))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return new TreeMap<>(methodsMap);
    }

    public Manager(DataTransferObject dto, Class<DataTransferObject> dtoClass) {
        this.dto = dto;
        this.dtoClass = dtoClass;

        getters = initGetters();
        setters = initSetters();
        columns = initColumns();

        getterRelated = initRelatedGetters();
        setterRelated = initRelatedSetters();
    }

    public Manager(DataTransferObject dto) {
        this(dto, (Class<DataTransferObject>) dto.getClass());
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

    private Map<String, Method> initRelatedGetters() {
        return getRelatedMethodsFromDTO(Getter.class);
    }

    public Map<String, Method> getGetterRelated() {
        return getterRelated;
    }

    private Map<String, Method> initRelatedSetters() {
        return getRelatedMethodsFromDTO(Setter.class);
    }

    public Map<String, Method> getSetterRelated() {
        return setterRelated;
    }

    public String getPKColumn() {
        return "pk";
    }

    public List<String> getColumnsButPK() {
        List<String> c = new ArrayList<>(getColumns());
        c.remove(getPKColumn());
        return c;
    }

    public String getTable() {
        return dtoClass.getAnnotation(Table.class).nome();
    }

    private Object getColumnValue(String column) throws InvocationTargetException, IllegalAccessException {
        return getGetters().get(column).invoke(dto);
    }

    private String getColumnValueAsString(String column) throws InvocationTargetException, IllegalAccessException {
        Object getResult = getColumnValue(column);
        if (getResult == null)
            return  "null";
        return getResult.toString();
    }

    private Map.Entry<String, String> columnValueAsStirng(String column) {
        try {
            return Map.entry(column, getColumnValueAsString(column));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private Map.Entry<String, Object> columnValue(String column) {
        try {
            return Map.entry(column, getColumnValue(column));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public Map<String, Object> toMap(List<String> columns) {
        return columns.stream()
                .map(this::columnValue)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<String, Object> toMap() {
        return toMap(getColumns());
    }

    public Map<String, String> toStringMap(List<String> columns) {
        return columns.stream()
                .map(this::columnValueAsStirng)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<String, String> toStringMap() {
        return toStringMap(getColumns());
    }

    public String toString(List<String> columns) {
        return toStringMap(columns).entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(", ", "{", "}"));
    }

    public String toString() {
        return toString(getColumns());
    }
}
