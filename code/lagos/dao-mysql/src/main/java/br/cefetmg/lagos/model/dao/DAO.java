package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dto.DTO;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public abstract class DAO {
    private TreeMap<String, Methods> getters;
    private TreeMap<String, Methods> setters;

    private static class Methods {
        public Method dto;
        public Method sql;

        public Methods(Method dto, Method sql) {
            this.dto = dto;
            this.sql = sql;
        }

        @Override
        public String toString() {
            return "(dto: " + dto.toString() + ", sql: " + sql.toString() + ")";
        }
    }

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static Method getMethodForLeakAndType(Class<? extends Annotation> leak, Method dtoMethod)
            throws NoSuchMethodException {
        if (leak == Getter.class) {
            Class<?> tipo = dtoMethod.getReturnType();
            return ResultSet.class.getMethod("get" + capitalize(tipo.getSimpleName()), String.class);
        } else {
            Class<?> tipo = dtoMethod.getParameterTypes()[0];
            return PreparedStatement.class.getMethod("set" + capitalize(tipo.getSimpleName()), int.class, tipo);
        }
    }

    private static TreeMap<String, Methods> getMethodsForColumnsOf(
            Class<? extends DTO> dto, Class<? extends Annotation> leak, List<String> columns) {
        Map<String, Methods> methodsMap = Arrays.stream(dto.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Column.class)
                        && method.isAnnotationPresent(leak)
                        && columns.contains(method.getAnnotation(Column.class).nome())
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

    private static TreeMap<String, Methods> getAllGettersOf(Class<? extends DTO> dto, List<String> columns) {
        return getMethodsForColumnsOf(dto, Getter.class, columns);
    }

    private static TreeMap<String, Methods> getAllSettersOf(Class<? extends DTO> dto, List<String> columns) {
        return getMethodsForColumnsOf(dto, Setter.class, columns);
    }

    protected abstract List<String> getGetterColumns();

    protected abstract List<String> getSetterColumns();

    protected abstract Class<? extends DTO> getDto();

    public DAO() {
        getters = getAllGettersOf(getDto(), getGetterColumns());
        setters = getAllSettersOf(getDto(), getSetterColumns());
    }

    protected void setAllStatementValues(Pessoa pessoa, PreparedStatement preparedStatement) throws SQLException {
        AtomicInteger i = new AtomicInteger(1);
        setters.forEach((column, methods) -> {
            try {
                methods.sql.invoke(preparedStatement, i.getAndIncrement(), methods.dto.invoke(pessoa));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
    }

    protected DTO getDTOFrom(ResultSet resultSet) throws SQLException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<? extends DTO> cDto = getDto().getConstructor();
        DTO dto = cDto.newInstance();

        getters.forEach((column, metods) -> {
            try {
                metods.dto.invoke(dto, metods.sql.invoke(column));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });

        return dto;
    }
}
