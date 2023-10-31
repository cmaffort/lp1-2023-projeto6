package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.util.DAOHelper;
import br.cefetmg.lagos.model.dao.util.StringSql;
import br.cefetmg.lagos.model.dao.util.StringSqlDaoHelper;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractDAO implements IDAO {
    protected final DAOHelper helper;
    private final String table;
    
    public AbstractDAO() {
        helper = new DAOHelper(getDTO());
        table = initTable();
    }

    protected abstract DTO getDTO();

    protected String getTable() {
        return table;
    }

    private String initTable() {
        return getDTO().getClass().getAnnotation(Table.class).nome();
    }

    protected List<List<String>> getColumnsPreparedStatementInserir() {
        return List.of(new ArrayList<>(getDTO().getManeger().getColumnsButPK()));
    }

    @Override
    public Long inserir(DTO dto) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = getColumnsPreparedStatementInserir();

        List<String> columns = helper.mergeLists(columnsPreparedStatement.toArray(new List[0]));

        String sql = StringSqlDaoHelper.insertWithValues(getTable(), columnsPreparedStatement.get(0));

        return helper.inserir(dto, sql, columns);
    }

    protected List<List<String>> getColumnsPreparedStatementAlterar() {
        return Arrays.asList(
                new ArrayList<>(getDTO().getManeger().getColumnsButPK()),
                List.of(getDTO().getManeger().getPKColumn())
        );
    }

    @Override
    public boolean alterar(DTO dto) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = getColumnsPreparedStatementAlterar();

        List<String> columns = helper.mergeLists(columnsPreparedStatement.toArray(new List[0]));

        String sql = StringSqlDaoHelper.updateSetWhereEq(getTable(), columnsPreparedStatement.get(0), columnsPreparedStatement.get(1));

        return helper.alterar(dto, sql, columns);
    }

    protected List<List<String>> getColumnsPreparedStatementRemover() {
        return List.of(List.of(getDTO().getManeger().getPKColumn()));
    }

    @Override
    public boolean remover(DTO dto) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = getColumnsPreparedStatementRemover();

        List<String> columns = helper.mergeLists(columnsPreparedStatement.toArray(new List[0]));

        String sql = StringSqlDaoHelper.deleteFromWhereEq(getTable(), columnsPreparedStatement.get(0));

        return helper.remover(dto, sql, columns);
    }

    protected List<List<String>> getColumnsResultSetListar() {
        return List.of(new ArrayList<>(getDTO().getManeger().getColumns()));
    }

    protected List<String> getOrderByPriority() {
        return List.of(getDTO().getManeger().getPKColumn());
    }

    protected String getSQLListar(List<List<String>> columnsResultSet) {
        return StringSqlDaoHelper.selectFromOrderBy(columnsResultSet.get(0), getTable(), getOrderByPriority());
    }

    @Override
    public List<? extends DTO> listar() throws PersistenceException {
        List<List<String>> columnsResultSet = getColumnsResultSetListar();

        List<String> allColumnsResultSet = helper.mergeLists(columnsResultSet.toArray(new List[0]));

        String sql = getSQLListar(columnsResultSet);

        return helper.listar(sql, allColumnsResultSet);
    }

    protected List<List<String>> getColumnsPreparedStatementConsultar() {
        return List.of(List.of(getDTO().getManeger().getPKColumn()));
    }

    protected List<List<String>> getColumnsResultSetConsultar() {
        return List.of(new ArrayList<>(getDTO().getManeger().getColumns()));
    }

    protected String getSQLConsultar(List<List<String>> columnsPreparedStatement, List<List<String>> columnsResultSet) {
        return StringSqlDaoHelper.selectAllFromWhereEq(getTable(), columnsPreparedStatement.get(0));
    }

    @Override
    public DTO consultarPorId(Long id) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = getColumnsPreparedStatementConsultar();

        List<List<String>> columnsResultSet = getColumnsResultSetConsultar();

        List<String> allColumnsPreparedStatement = helper.mergeLists(columnsPreparedStatement.toArray(new List[0]));
        List<String> allColumnsResultSet = helper.mergeLists(columnsResultSet.toArray(new List[0]));

        String sql = getSQLConsultar(columnsPreparedStatement, columnsResultSet);

        return helper.consultarPorId(id, sql, allColumnsPreparedStatement, allColumnsResultSet);
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

    protected String getSQLListarDTO(List<List<String>> columnsResultSet, DTO... dtos) {
        return StringSqlDaoHelper.selectFromWhere(columnsResultSet.get(0), getTable(),
                Arrays.stream(dtos)
                        .map(dto -> getWhereRelated(dto) + " = " + dto.getId())
                        .toList()
        ) + " " + StringSql.orderBy(getOrderByPriority());
    }

    protected List<? extends DTO> listar(DTO... dtos) throws PersistenceException {
        List<List<String>> columnsResultSet = getColumnsResultSetListar();

        List<String> allColumnsResultSet = helper.mergeLists(columnsResultSet.toArray(new List[0]));

        String sql = getSQLListarDTO(columnsResultSet, dtos);

        return helper.listar(sql, allColumnsResultSet);
    }

    protected String getSQLConsultarDTO(List<List<String>> columnsResultSet, DTO... dtos) {
        return StringSqlDaoHelper.selectFromWhere(columnsResultSet.get(0), getTable(),
                Arrays.stream(dtos)
                        .map(dto -> getWhereRelated(dto) + " = " + dto.getId())
                        .toList()
        );
    }

    protected DTO consultarPor(DTO... dtos) throws PersistenceException {
        List<List<String>> columnsResultSet = getColumnsResultSetConsultar();

        List<String> allColumnsResultSet = helper.mergeLists(columnsResultSet.toArray(new List[0]));

        String sql = getSQLConsultarDTO(columnsResultSet, dtos);

        return helper.consultarPor(sql, allColumnsResultSet);
    }
}
