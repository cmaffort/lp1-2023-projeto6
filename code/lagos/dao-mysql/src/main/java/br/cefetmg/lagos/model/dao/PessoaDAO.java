package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.util.DAO;
import br.cefetmg.lagos.model.dao.util.StringSql;
import br.cefetmg.lagos.model.dao.util.StringSqlDaoHelper;
import br.cefetmg.lagos.model.dto.Pessoa;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class PessoaDAO implements IPessoaDAO {
    private static final DAO dao;

    static {
        dao = new DAO(Pessoa.class);
    }

    protected static String getTable() {
        return "pessoa";
    }

    @Override
    public Long inserir(Pessoa pessoa) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = Arrays.asList(
                Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone")
        );

        List<String> columns = dao.mergeLists(columnsPreparedStatement.toArray(new List[0]));

        String sql = StringSqlDaoHelper.insertWithValues(getTable(), columnsPreparedStatement.get(0));

        return dao.inserir(pessoa, sql, columns);
    }

    @Override
    public boolean alterar(Pessoa pessoa) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = Arrays.asList(
                Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone"),
                List.of("pk")
        );

        List<String> columns = dao.mergeLists(columnsPreparedStatement.toArray(new List[0]));

        String sql = StringSqlDaoHelper.updateSetWhereEq(getTable(), columnsPreparedStatement.get(0), columnsPreparedStatement.get(1));

        return dao.alterar(pessoa, sql, columns);
    }

    @Override
    public boolean remover(Pessoa pessoa) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = Arrays.asList(
                List.of("pk")
        );

        List<String> columns = dao.mergeLists(columnsPreparedStatement.toArray(new List[0]));

        String sql = StringSqlDaoHelper.deleteFromWhereEq(getTable(), columnsPreparedStatement.get(0));

        return dao.remover(pessoa, sql, columns);
    }

    @Override
    public List<Pessoa> listar() throws PersistenceException {
        List<List<String>> columnsResultSet = Arrays.asList(
                Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone", "pk")
        );

        List<String> allColumnsResultSet = dao.mergeLists(columnsResultSet.toArray(new List[0]));

        String sql = StringSqlDaoHelper.selectFromOrderBy(columnsResultSet.get(0), getTable(),
                Arrays.asList("nome", "sobrenome"));

        return (List<Pessoa>) dao.listar(sql, allColumnsResultSet);
    }

    @Override
    public Pessoa cosultarPorId(Long id) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = Arrays.asList(
                List.of("pk")
        );

        List<List<String>> columnsResultSet = Arrays.asList(
                Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone", "pk")
        );

        List<String> allColumnsPreparedStatement = dao.mergeLists(columnsPreparedStatement.toArray(new List[0]));
        List<String> allColumnsResultSet = dao.mergeLists(columnsResultSet.toArray(new List[0]));

        String sql = StringSqlDaoHelper.selectAllFromWhereEq(getTable(), columnsPreparedStatement.get(0));

        return (Pessoa) dao.consultarPorId(id, sql, allColumnsPreparedStatement, allColumnsResultSet);
    }
}
