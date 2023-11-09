package br.cefetmg.lagos.model.dto.base;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.util.Pair;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Manager<DataTransferObject extends DTO<DataTransferObject>> {
    private final Class<DataTransferObject> dtoClass;
    private final DataTransferObject dto;

    private final TreeMap<String, Method> getters;
    private final TreeMap<String, Method> setters;
    private final List<String> columns;

    private final TreeMap<String, Method> gettersNotNull;

    private final TreeMap<String, Method> getterRelated;
    private final TreeMap<String, Method> setterRelated;

    private static String getRelatedNameFrom(Method method) {
        return method.getAnnotation(Related.class).nome();
    }

    private static String getColumnNameFrom(Method method) {
        return method.getAnnotation(Column.class).nome();
    }

    public Class<?> getTypeForColumn(String column) {
        return getters.get(column).getAnnotation(Column.class).tipo();
    }

    private TreeMap<String, Method> getMethodsFromDTO(Class<? extends Annotation> leak) {
        Map<String, Method> methodsMap = Arrays.stream(dtoClass.getMethods())
                .filter(method -> method.isAnnotationPresent(Column.class)
                        && method.isAnnotationPresent(leak)
                )
                .map(method -> Map.entry(getColumnNameFrom(method), method))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return new TreeMap<>(methodsMap);
    }

    private TreeMap<String, Method> getRelatedMethodsFromDTO(Class<? extends Annotation> leak) {
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

        gettersNotNull = initGettersNotNull();

        getterRelated = initRelatedGetters();
        setterRelated = initRelatedSetters();
    }

    public Manager(DataTransferObject dto) {
        this(dto, (Class<DataTransferObject>) dto.getClass());
    }

    private TreeMap<String, Method> initGetters() {
        return getMethodsFromDTO(Getter.class);
    }

    public TreeMap<String, Method> getGetters() {
        return getters;
    }

    private TreeMap<String, Method> initSetters() {
        return getMethodsFromDTO(Setter.class);
    }

    public TreeMap<String, Method> getSetters() {
        return setters;
    }

    private List<String> initColumns() {
        return new ArrayList<>(getters.keySet().stream().sorted().toList());
    }

    public List<String> getColumns() {
        return columns;
    }

    private TreeMap<String, Method> initRelatedGetters() {
        return getRelatedMethodsFromDTO(Getter.class);
    }

    public TreeMap<String, Method> getGetterRelated() {
        return getterRelated;
    }

    private TreeMap<String, Method> initRelatedSetters() {
        return getRelatedMethodsFromDTO(Setter.class);
    }

    public TreeMap<String, Method> getSetterRelated() {
        return setterRelated;
    }

    public List<String> getRelatedTables() {
        return new ArrayList<>(getterRelated.keySet());
    }

    public String getPKColumn() {
        return dtoClass.getDeclaredAnnotation(PrimaryKey.class).nome();
    }

    private TreeMap<String, Method> initGettersNotNull() {
        Map<String, Method> map = getters.entrySet().stream()
                .filter(entry -> entry.getValue().isAnnotationPresent(NotNull.class))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return new TreeMap<>(map);
    }

    public boolean hasAllNotNullFields(List<String> columns) {
        try {
            for (String column : columns) {
                Method method = gettersNotNull.get(column);
                if (method == null)
                    continue;
                if (method.invoke(dto) == null)
                    return false;
            }

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public boolean isTableRelated(DTO<?> relatedTable) {
        List<String> otherSideRelated = relatedTable.getManeger().getRelatedTables();
        List<String> allRelations = Stream.concat(getRelatedTables().stream(), otherSideRelated.stream()).toList();
        return allRelations.contains(relatedTable.getManeger().getTable());
    }

    public boolean areAllTablesRelated(List<DTO> relatedTables) {
        List<String> relatedTablesNames = relatedTables.stream()
                .map(dtoRelated -> dtoRelated.getManeger().getTable()).toList();

        List<String> otherSideRelated = relatedTables.stream()
                .map(related -> (List<String>) related.getManeger().getRelatedTables())
                .flatMap(Collection::stream).toList();

        List<String> allRelations = Stream.concat(getRelatedTables().stream(), otherSideRelated.stream()).toList();

        return Collections.indexOfSubList(allRelations, relatedTablesNames) != -1;
    }

    public List<String> getAllNotNullColumns() {
        return gettersNotNull.keySet().stream().toList();
    }

    public List<String> getAllNotNullColumnsButPk() {
        List<String> c = new ArrayList<>(gettersNotNull.keySet().stream().toList());
        c.remove(getPKColumn());
        return c;
    }

    public boolean hasAllNotNullFields() {
        return hasAllNotNullFields(getAllNotNullColumns());
    }

    public boolean hasAllNotNullFieldsButPk() {
        return hasAllNotNullFields(getAllNotNullColumnsButPk());
    }

    public List<String> getColumnsButPK() {
        List<String> c = new ArrayList<>(columns);
        c.remove(getPKColumn());
        return c;
    }

    public String getTable() {
        return dtoClass.getAnnotation(Table.class).nome();
    }

    private Object getColumnValue(String column) throws InvocationTargetException, IllegalAccessException {
        return getters.get(column).invoke(dto);
    }

    private String getColumnValueAsString(String column) throws InvocationTargetException, IllegalAccessException {
        Object getResult = getColumnValue(column);
        if (getResult == null)
            return  "null";
        return getResult.toString();
    }

    private Pair<String, String> columnValueAsStirng(String column) {
        try {
            return new Pair<>(column, getColumnValueAsString(column));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private Pair<String, Object> columnValue(String column) {
        try {
            return new Pair<>(column, getColumnValue(column));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public TreeMap<String, Object> toMap(List<String> columns) {
        return columns.stream()
                .map(this::columnValue)
                .collect(TreeMap::new, (map, pair) -> map.put(pair.first(), pair.second()), TreeMap::putAll);
    }

    public TreeMap<String, Object> toMap() {
        return toMap(columns);
    }

    public Map<String, String> toStringMap(List<String> columns) {
        return columns.stream()
                .map(this::columnValueAsStirng)
                .collect(Collectors.toMap(Pair::first, Pair::second));
    }

    public Map<String, String> toStringMap() {
        return toStringMap(columns);
    }

    public String toString(List<String> columns) {
        return getTable() + ": " + toStringMap(columns).entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(", ", "{", "}"));
    }

    public String toString() {
        return toString(columns);
    }
}
