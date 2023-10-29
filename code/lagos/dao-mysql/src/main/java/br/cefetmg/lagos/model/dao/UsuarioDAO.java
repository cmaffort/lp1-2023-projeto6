package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.util.DAO;
import br.cefetmg.lagos.model.dao.util.StringSql;
import br.cefetmg.lagos.model.dao.util.StringSqlDaoHelper;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.Usuario;
import br.cefetmg.lagos.model.dto.enums.TipoUsuario;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO {
    private static final DAO dao;
    private static final PessoaDAO pessoaDAO;

    static {
        dao = new DAO(Usuario.class);
        pessoaDAO = new PessoaDAO();
    }

    protected static String getTable() {
        return "usuario";
    }

    /**
     * A pessoa referente ao usuário não deve existir antes de cria-lo, nesse caso haverá uma duplicata no banco de dados
     */
    @Override
    public Long inserir(Usuario usuario) throws PersistenceException {
        Long id = pessoaDAO.inserir(usuario);

        usuario.setId(id);

        List<List<String>> columnsPreparedStatement = Arrays.asList(
                Arrays.asList("tipo", "username", "senha", "pk")
        );

        List<String> columns = dao.mergeLists(columnsPreparedStatement.toArray(new List[0]));

        String sql = StringSqlDaoHelper.insertWithValues(getTable(), columnsPreparedStatement.get(0));

        dao.inserir(usuario, sql, columns);
        return id;
    }

    @Override
    public boolean alterar(Usuario usuario) throws PersistenceException {
        pessoaDAO.alterar(usuario);

        List<List<String>> columnsPreparedStatement = Arrays.asList(
                Arrays.asList("tipo", "username", "senha"),
                List.of("pk")
        );

        List<String> columns = dao.mergeLists(columnsPreparedStatement.toArray(new List[0]));

        String sql = StringSqlDaoHelper.updateSetWhereEq(getTable(), columnsPreparedStatement.get(0), columnsPreparedStatement.get(1));

        return dao.alterar(usuario, sql, columns);
    }

    @Override
    public boolean remover(Usuario usuario) throws PersistenceException {
        return pessoaDAO.remover(usuario);
    }

    @Override
    public List<Usuario> listar() throws PersistenceException {
        List<List<String>> columnsResultSet = Arrays.asList(
                Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone", "tipo", "username", "senha", "pk")
        );

        List<String> allColumnsResultSet = dao.mergeLists(columnsResultSet.toArray(new List[0]));

        String sql = StringSqlDaoHelper.selectFromWhereOrderBy(Arrays.asList("nome", "sobrenome", "nascimento", "email",
                        "telefone", "tipo", "username", "senha", "usuario.pk"), Arrays.asList(getTable(), "pessoa"),
                Arrays.asList("pessoa.pk = usuario.pk"), Arrays.asList("nome", "sobrenome"));

        return (List<Usuario>) dao.listar(sql, allColumnsResultSet);
    }

    @Override
    public Usuario cosultarPorId(Long id) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = Arrays.asList(
                List.of("pk")
        );

        List<List<String>> columnsResultSet = Arrays.asList(
                Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone", "tipo", "username", "senha", "pk")
        );

        List<String> allColumnsPreparedStatement = dao.mergeLists(columnsPreparedStatement.toArray(new List[0]));
        List<String> allColumnsResultSet = dao.mergeLists(columnsResultSet.toArray(new List[0]));

        String sql = StringSqlDaoHelper.selectFromWhere(
                Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone", "tipo", "username", "senha", "usuario.pk"),
                Arrays.asList(getTable(), "pessoa"), Arrays.asList("usuario.pk = ?", "pessoa.pk = usuario.pk"));

        return (Usuario) dao.consultarPorId(id, sql, allColumnsPreparedStatement, allColumnsResultSet);
    }
}