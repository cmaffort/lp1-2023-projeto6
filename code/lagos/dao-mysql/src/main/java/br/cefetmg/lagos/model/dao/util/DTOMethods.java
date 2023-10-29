package br.cefetmg.lagos.model.dao.util;

import br.cefetmg.lagos.model.dto.DTO;
import br.cefetmg.lagos.model.dto.annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DTOMethods {
    private final Class<? extends DTO> dtoClass;
    private final Map<String, Methods> getters;
    private final Map<String, Methods> setters;
    private final List<String> allColumns;

    private static class Methods {
        public Method dto;
        public Method sql;

        public Methods(Method dto, Method sql) {
            this.dto = dto;
            this.sql = sql;
        }

        @Override
        public String toString() {
            return "(dto: " + dto.getName() + ", sql: " + sql.getName() + ")";
        }
    }

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static Class<?> intClassIfEnum(Class<?> clss) {
        return !clss.isEnum() ? clss : int.class;
    }

    private static Method getMethodForLeakAndType(Class<? extends Annotation> leak, Method dtoMethod)
            throws NoSuchMethodException {
        if (leak == Setter.class) {
            Class<?> tipo = intClassIfEnum(dtoMethod.getParameterTypes()[0]);
            return ResultSet.class.getMethod("get" + capitalize(tipo.getSimpleName()), String.class);
        } else {
            Class<?> tipo = intClassIfEnum(dtoMethod.getReturnType());
            return PreparedStatement.class.getMethod("set" + capitalize(tipo.getSimpleName()), int.class, tipo);
        }
    }

    private static Map<String, Methods> getMethodsForColumnsOf(
            Class<? extends DTO> dto, Class<? extends Annotation> leak) {
        Map<String, Methods> methodsMap = Arrays.stream(dto.getMethods())
                .filter(method -> method.isAnnotationPresent(Column.class)
                        && method.isAnnotationPresent(leak)
                )
                .map(method -> {
                    Column column = method.getAnnotation(Column.class);
                    try {
                        return Map.entry(column.nome(), new Methods(method, getMethodForLeakAndType(leak, method)));
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return new TreeMap<>(methodsMap);
    }

    private static Map<String, Methods> getAllGettersOf(Class<? extends DTO> dto) {
        return getMethodsForColumnsOf(dto, Getter.class);
    }

    private static Map<String, Methods> getAllSettersOf(Class<? extends DTO> dto) {
        return getMethodsForColumnsOf(dto, Setter.class);
    }

    private static List<Map.Entry<String, Methods>> getMethodsFromColumns(Map<String, Methods> methods,
                                                                              List<String> columns) {
        return columns.stream()
                .map(column -> Map.entry(column, methods.get(column)))
                .toList();
    }

    public DTOMethods(Class<? extends DTO> dtoClass) {
        this.dtoClass = dtoClass;
        getters = getAllGettersOf(dtoClass);
        setters = getAllSettersOf(dtoClass);
        HashSet<String> s = new HashSet<>(getters.keySet());
        s.addAll(setters.keySet());
        allColumns = new ArrayList<>(s);
    }

    public List<String> getAllColumns() {
        return allColumns;
    }

    public int setPreparedStatement(DTO dto, PreparedStatement preparedStatement, List<String> columns, int initial)
            throws SQLException {
        AtomicInteger i = new AtomicInteger(initial);
        getMethodsFromColumns(getters, columns).forEach(entry -> {
            Methods methods = entry.getValue();
            try {
                methods.sql.invoke(preparedStatement, i.getAndIncrement(), methods.dto.invoke(dto));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
        return i.get();
    }

    public int setPreparedStatement(DTO dto, PreparedStatement preparedStatement, List<String> columns)
            throws SQLException {
        return setPreparedStatement(dto, preparedStatement, columns, 1);
    }

    public DTO insertInto(DTO dto, ResultSet resultSet, List<String> columns) {
        AtomicInteger i = new AtomicInteger(1);
        getMethodsFromColumns(setters, columns).forEach(entry -> {
            String column = entry.getKey();
            Methods methods = entry.getValue();
            try {
                methods.dto.invoke(dto, methods.sql.invoke(resultSet, column));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });

        return dto;
    }

    public DTO createWith(ResultSet resultSet, List<String> columns) throws SQLException,
            NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return insertInto(getInstanceOfDTO(), resultSet, columns);
    }

    public DTO getInstanceOfDTO() throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Constructor<? extends DTO> constructorDto = dtoClass.getConstructor();
        return constructorDto.newInstance();
    }
}
