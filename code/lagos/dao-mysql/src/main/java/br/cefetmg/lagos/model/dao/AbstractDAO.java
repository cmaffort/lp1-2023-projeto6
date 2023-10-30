package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.util.DAOHelper;
import br.cefetmg.lagos.model.dao.util.StringSql;
import br.cefetmg.lagos.model.dao.util.StringSqlDaoHelper;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;

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

    protected abstract List<List<String>> getColumnsPreparedStatementInserir();

    @Override
    public Long inserir(DTO pessoa) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = getColumnsPreparedStatementInserir();

        List<String> columns = helper.mergeLists(columnsPreparedStatement.toArray(new List[0]));

        String sql = StringSqlDaoHelper.insertWithValues(getTable(), columnsPreparedStatement.get(0));

        return helper.inserir(pessoa, sql, columns);
    }

    protected abstract List<List<String>> getColumnsPreparedStatementAlterar();

    @Override
    public boolean alterar(DTO pessoa) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = getColumnsPreparedStatementAlterar();

        List<String> columns = helper.mergeLists(columnsPreparedStatement.toArray(new List[0]));

        String sql = StringSqlDaoHelper.updateSetWhereEq(getTable(), columnsPreparedStatement.get(0), columnsPreparedStatement.get(1));

        return helper.alterar(pessoa, sql, columns);
    }

    protected abstract List<List<String>> getColumnsPreparedStatementRemover();

    @Override
    public boolean remover(DTO pessoa) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = getColumnsPreparedStatementRemover();

        List<String> columns = helper.mergeLists(columnsPreparedStatement.toArray(new List[0]));

        String sql = StringSqlDaoHelper.deleteFromWhereEq(getTable(), columnsPreparedStatement.get(0));

        return helper.remover(pessoa, sql, columns);
    }

    protected abstract List<List<String>> getColumnsResultSetListar();

    protected abstract List<String> getOrderByPriority();

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

    protected abstract List<List<String>> getColumnsPreparedStatementConsultar();

    protected abstract List<List<String>> getColumnsResultSetConsultar();

    protected String getSQLConsultar(List<List<String>> columnsPreparedStatement, List<List<String>> columnsResultSet) {
        return StringSqlDaoHelper.selectAllFromWhereEq(getTable(), columnsPreparedStatement.get(0));
    }

    @Override
    public DTO cosultarPorId(Long id) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = getColumnsPreparedStatementConsultar();

        List<List<String>> columnsResultSet = getColumnsResultSetConsultar();

        List<String> allColumnsPreparedStatement = helper.mergeLists(columnsPreparedStatement.toArray(new List[0]));
        List<String> allColumnsResultSet = helper.mergeLists(columnsResultSet.toArray(new List[0]));

        String sql = getSQLConsultar(columnsPreparedStatement, columnsResultSet);

        return helper.consultarPorId(id, sql, allColumnsPreparedStatement, allColumnsResultSet);
    }

    private String getWhereRelated(DTO dto) {
        String tableDto = dto.getClass().getAnnotation(Table.class).nome();
        String fk = tableDto + "__fk";
        if (!getDTO().getManeger().getColumns().contains(fk))
            return "pk";
        return fk;
    }

    protected String getSQLListarDTO(List<List<String>> columnsResultSet, DTO dto) {
        return StringSqlDaoHelper.selectFromWhere(columnsResultSet.get(0), getTable(),
                List.of(getWhereRelated(dto) + " = " + dto.getId())) + " " + StringSql.orderBy(getOrderByPriority());
    }

    protected List<? extends DTO> listar(DTO dto) throws PersistenceException {
        List<List<String>> columnsResultSet = getColumnsResultSetListar();

        List<String> allColumnsResultSet = helper.mergeLists(columnsResultSet.toArray(new List[0]));

        String sql = getSQLListar(columnsResultSet);

        return helper.listar(sql, allColumnsResultSet);
    }
}
