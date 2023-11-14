package br.cefetmg.lagos.model.dao.util;

import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.Manager;
import br.cefetmg.lagos.model.dto.exceptions.DTOExeption;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DTODb<DataTransferObject extends DTO<DataTransferObject>> {
    private final DataTransferObject dto;
    private final Manager<DataTransferObject> manager;

    private final Map<String, MethodType> getters;
    private final Map<String, MethodType> setters;

    public DTODb(DataTransferObject dto) {
        this.dto = dto;
        manager = dto.getManeger();
        getters = initGetters();
        setters = initSetters();
    }

    private static class MethodType {
        public Method method;
        public Class<?> type;

        public MethodType(Method method, Class<?> type) {
            this.method = method;
            this.type = type;
        }

        @Override
        public String toString() {
            return "(dto: " + method.getName() + ", db: " + type.getName() + ")";
        }
    }

    private Map<String, MethodType> getMethods(Map<String, Method> dtoMethods) {
        Map<String, MethodType> methodsMap = dtoMethods.entrySet().stream()
                .map(entry -> Map.entry(entry.getKey(), new MethodType(entry.getValue(), manager.getTypeForColumn(entry.getKey()))))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return new TreeMap<>(methodsMap);
    }

    private Map<String, MethodType> initGetters() {
        return getMethods(manager.getGetters());
    }

    private Map<String, MethodType> initSetters() {
        return getMethods(manager.getSetters());
    }

    private static List<Map.Entry<String, MethodType>> getMethodsForColumns(Map<String, MethodType> methods, List<String> columns) {
        return columns.stream()
                .map(column -> Map.entry(column, methods.get(column)))
                .toList();
    }

    private List<Map.Entry<String, MethodType>> getGettersForColumns(List<String> columns) {
        return getMethodsForColumns(getters, columns);
    }

    private List<Map.Entry<String, MethodType>> getSettersForColumns(List<String> columns) {
        return getMethodsForColumns(setters, columns);
    }

    public int setPreparedStatement(DataTransferObject dto, PreparedStatement preparedStatement, List<String> columns, int initial) {
        if (columns.isEmpty())
            return initial;

        AtomicInteger i = new AtomicInteger(initial);
        getGettersForColumns(columns).forEach(entry -> {
            MethodType methodType = entry.getValue();
            try {
                preparedStatement.setObject(i.getAndIncrement(), methodType.method.invoke(dto));
            } catch (IllegalAccessException | InvocationTargetException | SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return i.get();
    }

    public int setPreparedStatement(DataTransferObject dto, PreparedStatement preparedStatement, List<String> columns) {
        return setPreparedStatement(dto, preparedStatement, columns, 1);
    }

    public DataTransferObject insertInto(DataTransferObject dto, ResultSet resultSet, List<String> columns) {
        if (columns.isEmpty())
            return dto;

        getSettersForColumns(columns).forEach(entry -> {
            String column = entry.getKey();
            MethodType methodType = entry.getValue();
            try {
                methodType.method.invoke(dto, resultSet.getObject(column, methodType.type));
            } catch (IllegalAccessException | InvocationTargetException | SQLException e) {
                throw new RuntimeException(e);
            }
        });

        return dto;
    }

    public DataTransferObject createWith(ResultSet resultSet, List<String> columns) throws DTOExeption {
        return insertInto(dto.getInstance(), resultSet, columns);
    }
}
