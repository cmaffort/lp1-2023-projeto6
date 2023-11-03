package br.cefetmg.lagos.model.dao.base;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.util.DAOHelper;
import br.cefetmg.lagos.model.dao.util.StringSql;
import br.cefetmg.lagos.model.dao.util.StringSqlDaoHelper;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class AbstractDAO<DataTransferObject extends DTO<DataTransferObject>> implements IDAO<DataTransferObject> {
    protected final DAOHelper<DataTransferObject> helper;
    private final String table;
    
    public AbstractDAO() {
        helper = new DAOHelper<>(getDTO());
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

    @Override
    public Long inserir(DataTransferObject dto) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = getColumnsPreparedStatementInserir();

        List<String> allColumnsPreparedStatement = helper.mergeLists(columnsPreparedStatement.toArray(new List[0]));

        String sql = getSqlInserir(columnsPreparedStatement);

        return helper.executeUpdateGettingId(dto, sql, allColumnsPreparedStatement);
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

        List<String> allColumnsPreparedStatement = helper.mergeLists(columnsPreparedStatement.toArray(new List[0]));

        String sql = getSqlAlterar(columnsPreparedStatement);

        return helper.executeUpdate(dto, sql, allColumnsPreparedStatement);
    }

    protected List<List<String>> getColumnsPreparedStatementRemover() {
        return List.of(List.of(getDTO().getManeger().getPKColumn()));
    }

    protected String getSqlRemover(List<List<String>> columnsPreparedStatement) {
        return StringSqlDaoHelper.deleteFromWhereEq(getTable(), columnsPreparedStatement.get(0));
    }

    @Override
    public boolean remover(DataTransferObject dto) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = getColumnsPreparedStatementRemover();

        List<String> allColumnsPreparedStatement = helper.mergeLists(columnsPreparedStatement.toArray(new List[0]));

        String sql = getSqlRemover(columnsPreparedStatement);

        return helper.executeUpdate(dto, sql, allColumnsPreparedStatement);
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

        List<String> allColumnsResultSet = helper.mergeLists(columnsResultSet.toArray(new List[0]));

        String sql = getSqlListar(columnsResultSet);

        return fillFKedDTOs(helper.executeQueryGettingList(sql, allColumnsResultSet));
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
        List<List<String>> columnsPreparedStatement = getColumnsPreparedStatementConsultar();

        List<List<String>> columnsResultSet = getColumnsResultSetConsultar();

        List<String> allColumnsPreparedStatement = helper.mergeLists(columnsPreparedStatement.toArray(new List[0]));
        List<String> allColumnsResultSet = helper.mergeLists(columnsResultSet.toArray(new List[0]));

        String sql = getSqlConsultar(columnsPreparedStatement, columnsResultSet);

        return fillFKedDTOs(helper.consultarPorId(id, sql, allColumnsPreparedStatement, allColumnsResultSet));
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
        List<String> allColumnsResultSet = helper.mergeLists(columnsResultSet.toArray(new List[0]));

        String sql = getSqlFiltrar(columnsResultSet, Arrays.asList(columnsFilter));

        return fillFKedDTOs(helper.executeQueryGettingList(dto, sql, allColumnsPreparedStatement, allColumnsResultSet));
    }

    protected String getWhereRelated(DTO dto) {
        String tableDto = dto.getClass().getAnnotation(Table.class).nome();
        String fk = tableDto + "__fk";

        // No banco de dados é padronizado que toda Foreing Key termina em __fk e começa pelo nome da tabela referenciada
        // Todavia, em relações de um para um, por vezes a chave estrangeira é a própria chave primária
        if (!getDTO().getManeger().getColumns().contains(fk))
            return "pk";
        return fk;
    }

    protected List<String> getWhereStatementsFromRelatedDTOs(List<DTO> dtos) {
        return dtos.stream()
                .map(dto -> getWhereRelated(dto) + " = " + dto.getId())
                .toList();
    }

    protected String getSqlFiltrarRelated(List<List<String>> columnsResultSet, List<String> whereStatements) {
        return StringSqlDaoHelper.selectFromWhere(columnsResultSet.get(0), getTable(), whereStatements)
                + " " + StringSql.orderBy(getOrderByPriority());
    }

    @Override
    public List<DataTransferObject> filtrarRelated(DTO... related) throws PersistenceException {
        List<List<String>> columnsResultSet = getColumnsResultSetListar();

        List<String> allColumnsResultSet = helper.mergeLists(columnsResultSet.toArray(new List[0]));

        String sql = getSqlFiltrarRelated(columnsResultSet, getWhereStatementsFromRelatedDTOs(Arrays.asList(related)));

        return fillFKedDTOs(helper.executeQueryGettingList(sql, allColumnsResultSet));
    }

    protected Map<String, IDAO> getDAOs() {
        return null;
    }

    protected DataTransferObject fillFKedDTOs(DataTransferObject dto) throws PersistenceException {
        Map<String, IDAO> daos = getDAOs();
        if (getDAOs() == null)
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

    protected List<DataTransferObject> fillFKedDTOs(List<DataTransferObject> dtos) throws PersistenceException {
        for (DataTransferObject dto : dtos)
            fillFKedDTOs(dto);
        return dtos;
    }
}