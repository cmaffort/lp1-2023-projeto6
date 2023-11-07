package br.cefetmg.lagos.model.dao.base;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.util.JDBCOperation;
import br.cefetmg.lagos.model.dao.util.StringSql;
import br.cefetmg.lagos.model.dao.util.StringSqlDaoHelper;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.Manager;
import br.cefetmg.lagos.util.Pair;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractDAO<DataTransferObject extends DTO<DataTransferObject>> implements IDAO<DataTransferObject> {
    private final String table;
    
    protected AbstractDAO() {
        table = initTable();
    }

    protected abstract DataTransferObject getDTO();

    protected String getTable() {
        return table;
    }

    private String initTable() {
        return getDTO().getManeger().getTable();
    }

    protected List<List<String>> getColumnsPreparedStatementInserir() {
        return List.of(new ArrayList<>(getDTO().getManeger().getColumnsButPK()));
    }

    protected String getSqlInserir(List<List<String>> columnsPreparedStatement) {
        return StringSqlDaoHelper.insertWithValues(getTable(), columnsPreparedStatement.get(0));
    }

    protected static <T> List<T> mergeLists(List<T>... lists) {
        return Stream.of(lists)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public Long inserir(DataTransferObject dto) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = getColumnsPreparedStatementInserir();

        List<String> allColumnsPreparedStatement = mergeLists(columnsPreparedStatement.toArray(new List[0]));
        String sql = getSqlInserir(columnsPreparedStatement);

        Long id = new JDBCOperation.Builder<>(getDTO())
                .setSql(sql)
                .setColumnsPreparedStatement(allColumnsPreparedStatement, Statement.RETURN_GENERATED_KEYS, dto)
                .getId();

        if (id != null)
            dto.setId(id);

        return id;
    }

    protected List<List<String>> getColumnsPreparedStatementAlterar() {
        return Arrays.asList(
                new ArrayList<>(getDTO().getManeger().getColumnsButPK()),
                List.of(getDTO().getManeger().getPKColumn())
        );
    }

    protected String getSqlAlterar(List<List<String>> columnsPreparedStatement) {
        return StringSqlDaoHelper.updateSetWhereEq(getTable(), columnsPreparedStatement.get(0), columnsPreparedStatement.get(1));
    }

    @Override
    public boolean alterar(DataTransferObject dto) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = getColumnsPreparedStatementAlterar();

        List<String> allColumnsPreparedStatement = mergeLists(columnsPreparedStatement.toArray(new List[0]));
        String sql = getSqlAlterar(columnsPreparedStatement);

        new JDBCOperation.Builder<>(getDTO())
                .setSql(sql)
                .setColumnsPreparedStatement(allColumnsPreparedStatement, dto)
                .executeUpdate();

        return true;
    }

    protected List<List<String>> getColumnsPreparedStatementRemover() {
        return List.of(List.of(getDTO().getManeger().getPKColumn()));
    }

    protected String getSqlRemover(List<List<String>> columnsPreparedStatement) {
        return StringSqlDaoHelper.deleteFromWhereEq(table, columnsPreparedStatement.get(0));
    }

    @Override
    public boolean remover(DataTransferObject dto) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = getColumnsPreparedStatementRemover();

        List<String> allColumnsPreparedStatement = mergeLists(columnsPreparedStatement.toArray(new List[0]));
        String sql = getSqlRemover(columnsPreparedStatement);

        new JDBCOperation.Builder<>(getDTO())
                .setSql(sql)
                .setColumnsPreparedStatement(allColumnsPreparedStatement, dto)
                .executeUpdate();

        return true;
    }

    protected List<List<String>> getColumnsResultSetListar() {
        return List.of(new ArrayList<>(getDTO().getManeger().getColumns()));
    }

    protected List<String> getOrderByPriority() {
        return List.of(getDTO().getManeger().getPKColumn());
    }

    protected String getSqlListar(List<List<String>> columnsResultSet) {
        return StringSqlDaoHelper.selectFromOrderBy(columnsResultSet.get(0), getTable(), getOrderByPriority());
    }

    @Override
    public List<DataTransferObject> listar() throws PersistenceException {
        List<List<String>> columnsResultSet = getColumnsResultSetListar();

        List<String> allColumnsResultSet = mergeLists(columnsResultSet.toArray(new List[0]));
        String sql = getSqlListar(columnsResultSet);

        return fillFKedDTOs(
                new JDBCOperation.Builder<>(getDTO())
                        .setSql(sql)
                        .setColumnsResultSet(allColumnsResultSet)
                        .getInstances()
        );
    }

    protected List<List<String>> getColumnsPreparedStatementConsultar() {
        return List.of(List.of(getDTO().getManeger().getPKColumn()));
    }

    protected List<List<String>> getColumnsResultSetConsultar() {
        return List.of(new ArrayList<>(getDTO().getManeger().getColumns()));
    }

    protected String getSqlConsultar(List<List<String>> columnsPreparedStatement, List<List<String>> columnsResultSet) {
        return StringSqlDaoHelper.selectAllFromWhereEq(getTable(), columnsPreparedStatement.get(0));
    }

    @Override
    public DataTransferObject consultarPorId(Long id) throws PersistenceException {
        if (id == null)
            return null;

        List<List<String>> columnsPreparedStatement = getColumnsPreparedStatementConsultar();
        List<List<String>> columnsResultSet = getColumnsResultSetConsultar();

        List<String> allColumnsPreparedStatement = mergeLists(columnsPreparedStatement.toArray(new List[0]));
        List<String> allColumnsResultSet = mergeLists(columnsResultSet.toArray(new List[0]));
        String sql = getSqlConsultar(columnsPreparedStatement, columnsResultSet);

        DataTransferObject dtoId;

        try {
            dtoId = getDTO().getInstance();
            dtoId.setId(id);
        } catch (Exception e) {
            throw JDBCOperation.handleExeption(e);
        }

        return fillFKedDTOs(
                new JDBCOperation.Builder<>(getDTO())
                        .setSql(sql)
                        .setColumnsPreparedStatement(allColumnsPreparedStatement, dtoId)
                        .setColumnsResultSet(allColumnsResultSet)
                        .getInstance()
        );
    }

    protected String getSqlIdIn(List<List<String>> columnsResultSet, List<String> valuesIn) {
        String id = getDTO().getManeger().getPKColumn();
        return StringSqlDaoHelper.selectFromWhereIn(columnsResultSet.get(0), table, id, valuesIn)
                + " " + StringSql.orderBy(List.of(StringSql.field(id, valuesIn)));
    }

    public List<DataTransferObject> consultarPorIdIn(Long... ids) throws PersistenceException {
        List<List<String>> columnsResultSet = getColumnsResultSetConsultar();

        List<String> allColumnsResultSet = mergeLists(columnsResultSet.toArray(new List[0]));
        String sql = getSqlIdIn(columnsResultSet, Arrays.stream(ids).map(Object::toString).toList());

        return fillFKedDTOs(
                new JDBCOperation.Builder<>(getDTO())
                        .setSql(sql)
                        .setColumnsResultSet(allColumnsResultSet)
                        .getInstances()
        );
    }

    protected List<List<String>> getColumnsResultSetFiltrar() {
        return List.of(getDTO().getManeger().getColumns());
    }

    protected String getSqlFiltrar(List<List<String>> columnsResultSet, List<String> whereStatements) {
        return StringSqlDaoHelper.selectFromWhereEq(columnsResultSet.get(0), getTable(), whereStatements);
    }

    @Override
    public List<DataTransferObject> filtrar(DataTransferObject dto, String... columnsFilter) throws PersistenceException {
        List<List<String>> columnsResultSet = getColumnsResultSetFiltrar();

        List<String> allColumnsPreparedStatement = Arrays.asList(columnsFilter);
        List<String> allColumnsResultSet = mergeLists(columnsResultSet.toArray(new List[0]));

        String sql = getSqlFiltrar(columnsResultSet, Arrays.asList(columnsFilter));

        return fillFKedDTOs(
                new JDBCOperation.Builder<>(getDTO())
                        .setSql(sql)
                        .setColumnsPreparedStatement(allColumnsPreparedStatement, dto)
                        .setColumnsResultSet(allColumnsResultSet)
                        .getInstances()
        );
    }

    protected Pair<String, Method> getWhereRelated(DTO dto) {
        Manager managerDTO = dto.getManeger();
        Manager<DataTransferObject> managerThis = getDTO().getManeger();

        String fk = managerDTO.getTable() + "__fk";

        // No banco de dados é padronizado que toda Foreing Key termina em __fk e começa pelo nome da tabela referenciada
        // Todavia, em relações de um para um, por vezes a chave estrangeira é a própria chave primária
        if (!managerThis.getColumns().contains(fk)) {
            fk = managerThis.getTable() + "__fk";

            // Se aqui for verdadeiro a relação dessa dto com a passada é de herança e essa dto herda da passada
            if (!managerDTO.getColumns().contains(fk))
                return new Pair<>(managerThis.getPKColumn(), (Method) managerDTO.getGetters().get(managerDTO.getPKColumn()));

            // Se chegar aqui a dto passada possuí uma relação para a essa dto por meio do fk atual
            return new Pair<>(managerThis.getPKColumn(), (Method) managerDTO.getGetters().get(fk));
        }

        // Se chegar aqui essa dto tem uma relação para a dto passada por meio do fk
        return new Pair<>(fk, (Method) managerDTO.getGetters().get(managerDTO.getPKColumn()));
    }

    protected List<String> getWhereStatementsFromRelatedDTOs(List<DTO> dtos) {
        return dtos.stream()
                .map(dto -> {
                    Pair<String, Method> whereRelated = getWhereRelated(dto);
                    try {
                        return whereRelated.first() + " = " + whereRelated.second().invoke(dto);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e.getMessage(), e);
                    }
                })
                .toList();
    }

    protected String getSqlFiltrarRelated(List<List<String>> columnsResultSet, List<String> whereStatements) {
        return StringSqlDaoHelper.selectFromWhere(columnsResultSet.get(0), table, whereStatements)
                + " " + StringSql.orderBy(getOrderByPriority());
    }

    @Override
    public List<DataTransferObject> filtrarRelated(DTO... related) throws PersistenceException {
        List<List<String>> columnsResultSet = getColumnsResultSetListar();

        List<String> allColumnsResultSet = mergeLists(columnsResultSet.toArray(new List[0]));

        String sql = getSqlFiltrarRelated(columnsResultSet, getWhereStatementsFromRelatedDTOs(Arrays.asList(related)));

        return fillFKedDTOs(
                new JDBCOperation.Builder<>(getDTO())
                        .setSql(sql)
                        .setColumnsResultSet(allColumnsResultSet)
                        .getInstances()
        );
    }

    protected String getSqlFiltrarRelatedEqualTypes(List<List<String>> columnsResultSet, String columnWhere,
                                                    List<String> valuesIn) {
        return StringSqlDaoHelper.selectInRepeating(columnsResultSet.get(0), table, columnWhere, valuesIn);
    }

    public List<DataTransferObject> filtrarRelatedIn(DTO<?>... related) throws PersistenceException {
        List<List<String>> columnsResultSet = getColumnsResultSetListar();

        List<String> allColumnsResultSet = mergeLists(columnsResultSet.toArray(new List[0]));

        Pair<String, Method> whereRelated = getWhereRelated(related[0]);

        String sql = getSqlFiltrarRelatedEqualTypes(columnsResultSet, whereRelated.first(),
                Arrays.stream(related)
                        .map(relatedDTO -> {
                            try {
                                return whereRelated.second().invoke(relatedDTO).toString();
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                throw new RuntimeException(e.getMessage(), e);
                            }
                        })
                        .toList());

        return fillFKedDTOs(
                new JDBCOperation.Builder<>(getDTO())
                        .setSql(sql)
                        .setColumnsResultSet(allColumnsResultSet)
                        .getInstances()
        );
    }

    protected Map<String, IDAO> getDAOs() {
        return Map.of();
    }

    protected DataTransferObject fillFKedDTOs(DataTransferObject dto) {
        Map<String, IDAO> daos = getDAOs();
        if (daos == null)
            return dto;

        Map<String, Method> getters = dto.getManeger().getGetterRelated();
        Map<String, Method> setters = dto.getManeger().getSetterRelated();

        daos.forEach((name, dao) -> {
            Method getter = getters.get(name);
            Method setter = setters.get(name);
            try {
                DTO<?> related = dao.consultarPorId(((DTO<?>) getter.invoke(dto)).getId());
                setter.invoke(dto, related);
            } catch (PersistenceException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });

        return dto;
    }

    protected List<DataTransferObject> fillFKedDTOs(List<DataTransferObject> dtos) {
        Map<String, IDAO> daos = getDAOs();
        if (daos == null || dtos == null || dtos.isEmpty())
            return dtos;

        Map<String, Method> setters = getDTO().getManeger().getSetterRelated();

        daos.forEach((name, dao) -> {
            Method setter = setters.get(name);
            try {
                List<DTO<?>> related = dao.filtrarRelatedIn(dtos.toArray(new DTO<?>[0]));
                if (related.size() != dtos.size())
                    throw new PersistenceException("Não existem campos relacionados para todas as dtos.");
                for (int i = 0; i < dtos.size(); i++)
                    setter.invoke(dtos.get(i), related.get(i));
            } catch (PersistenceException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });

        return dtos;
    }

    protected List<String> getSqlManyToManyColumns() {
        Manager<DataTransferObject> manager = getDTO().getManeger();
        List<String> columns = manager.getColumnsButPK();
        columns.add(manager.getTable() + "." + manager.getPKColumn());
        return columns;
    }

    protected String getSqlManyToMany(List<String> columnsSelect, DTO associationTable, DTO relatedManyToMany) {
        return StringSqlDaoHelper.selectFromManyToMany(getSqlManyToManyColumns(), table, associationTable.getManeger().getTable(),
                relatedManyToMany.getManeger().getTable(), getDTO().getManeger().getPKColumn(), relatedManyToMany.getId().toString());
    }

    protected List<DataTransferObject> selectFromManyToMany(DTO associationTable, DTO relatedManyToMany) throws PersistenceException {
        List<List<String>> columnsResultSet = getColumnsResultSetListar();

        List<String> allColumnsResultSet = mergeLists(columnsResultSet.toArray(new List[0]));
        String sql = getSqlManyToMany(columnsResultSet.get(0), associationTable, relatedManyToMany);

        return fillFKedDTOs(
                new JDBCOperation.Builder<>(getDTO())
                        .setSql(sql)
                        .setColumnsResultSet(allColumnsResultSet)
                        .getInstances()
        );
    }
}
