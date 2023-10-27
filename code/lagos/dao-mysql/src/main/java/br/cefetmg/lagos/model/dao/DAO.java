package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.connections.ConnectionManager;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.util.StringSql;
import br.cefetmg.lagos.model.dto.DTO;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class DAO {
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
        Map<String, Methods> methodsMap = Arrays.stream(dto.getDeclaredMethods())
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

    protected abstract Class<? extends DTO> getDTO();
    protected abstract String getTable();

    public DAO() {
        getters = getAllGettersOf(getDTO());
        setters = getAllSettersOf(getDTO());
        HashSet<String> s = new HashSet<>(getters.keySet());
        s.addAll(setters.keySet());
        allColumns = new ArrayList<>(s);
    }

    protected List<String> getAllColumns() {
        return allColumns;
    }

    protected List<String> getAllColumnsButPk() {
        List<String> allColumnsButPk = new ArrayList<>(getAllColumns());
        allColumnsButPk.remove("pk");
        return allColumnsButPk;
    }

    @SafeVarargs
    protected final <T> List<T> mergeLists(List<T>... lists) {
        return Stream.of(lists)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    protected void setStatementValuesFor(DTO dto, PreparedStatement preparedStatement, List<String> columns)
            throws SQLException {
        AtomicInteger i = new AtomicInteger(1);
        getMethodsFromColumns(getters, columns).forEach(entry -> {
            Methods methods = entry.getValue();
            try {
                methods.sql.invoke(preparedStatement, i.getAndIncrement(), methods.dto.invoke(dto));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
    }

    protected DTO insertValues(DTO dto, ResultSet resultSet, List<String> columns) {
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

    protected DTO getWithValues(ResultSet resultSet, List<String> columns) throws SQLException,
            NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return insertValues(getInstanceOfDTO(), resultSet, columns);
    }

    protected PersistenceException handleExeption(Exception e) throws PersistenceException {
        e.printStackTrace();
        return new PersistenceException(e.getMessage(), e);
    }

    private DTO getInstanceOfDTO() throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Constructor<? extends DTO> constructorDto = getDTO().getConstructor();
        return constructorDto.newInstance();
    }

    /** Precisa ser uma coluna da tabela */
    protected abstract List<String> getColumnsInsert();

    protected String getInsertStatement(List<String> columnsInsert) {
        return StringSql.insertWithValues(getTable(), columnsInsert);
    }
    
    public Long inserir(DTO dto) throws PersistenceException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            List<String> columnsInsert = getColumnsInsert();

            String sql = getInsertStatement(columnsInsert);

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setStatementValuesFor(dto, preparedStatement, columnsInsert);
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            Long id = null;
            if (resultSet.next())
                id = resultSet.getLong(1);

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return id;
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }

    /** Precisa ser uma coluna da tabela */
    protected abstract List<String> getColumnsUpdateSet();

    protected String getUpdateSetStatement(List<String> columnsUpdateSet) {
        return StringSql.set(columnsUpdateSet);
    }

    /** Precisa ser uma coluna da tabela */
    protected abstract List<String> getColumnsWhere();

    protected String getWhereStatement(List<String> columnsWhere) {
        return StringSql.whereEq(columnsWhere);
    }
    
    public boolean alterar(DTO dto) throws PersistenceException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            List<String> columnsUpdate = getColumnsUpdateSet();
            List<String> columnsWhere = getColumnsWhere();

            String sql = StringSql.bigStatement(StringSql.update(getTable()), getUpdateSetStatement(columnsUpdate),
                    getWhereStatement(columnsWhere));

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            setStatementValuesFor(dto, preparedStatement, mergeLists(columnsUpdate, columnsWhere));

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return true;
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }
    
    public boolean remover(DTO dto) throws PersistenceException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            List<String> columnsWhere = getColumnsWhere();

            String sql = StringSql.bigStatement(StringSql.deleteFrom(getTable()), getWhereStatement(columnsWhere));

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            setStatementValuesFor(dto, preparedStatement, columnsWhere);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return true;
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }

    /** Não precisa ser uma coluna da tabela */
    protected abstract List<String> getColumnsOrderBy();

    protected String getOrderByStatement(List<String> columnsOrderBy) {
        return StringSql.orderBy(columnsOrderBy);
    }

    /** Não precisa ser uma coluna da tabela */
    protected abstract List<String> getColumnsSelect();

    protected String getSelectStatement(List<String> columnsSelect) {
        return StringSql.selectAll();
    }

    protected String getFromStatement() {
        return StringSql.from(getTable());
    }
    
    public List<? extends DTO> listar() throws PersistenceException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            List<String> columnsSelect = getColumnsSelect();
            List<String> columnsOrderBy = getColumnsOrderBy();

            String sql = StringSql.bigStatement(getSelectStatement(columnsSelect), getFromStatement(),
                    getOrderByStatement(columnsOrderBy));

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<DTO> dtos = null;
            if (resultSet.next()) {
                dtos = new ArrayList<>();
                do
                    dtos.add(getWithValues(resultSet, getColumnsSelect()));
                while (resultSet.next());
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return dtos;
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }
    
    public DTO cosultarPorId(Long id, DTO dto) throws PersistenceException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            List<String> columnsSelect = getColumnsSelect();
            List<String> columnsWhere = getColumnsWhere();

            String sql = StringSql.bigStatement(getSelectStatement(columnsSelect), getFromStatement(),
                    getWhereStatement(columnsWhere));

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            setStatementValuesFor(dto, preparedStatement, columnsWhere);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
                insertValues(dto, resultSet, getColumnsSelect());
            else
                dto = null;

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return dto;
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }

    public static void main(String[] args) {
        List<String> columns = Arrays.asList("nome", "email", "nascimento", "nome");
        Map<String, Methods> getters = getAllGettersOf(Pessoa.class);
        Map<String, Methods> setters = getAllSettersOf(Pessoa.class);
        System.out.println(getMethodsFromColumns(setters, columns));
    }
}
