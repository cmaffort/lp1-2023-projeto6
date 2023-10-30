package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.IPessoaDAO;
import br.cefetmg.lagos.model.dao.PessoaDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.util.StringSqlDaoHelper;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.contrato.Usuario;

import java.util.Arrays;
import java.util.List;

public class UsuarioDAO extends AbstractDAO implements IUsuarioDAO {
    @Override
    protected DTO getDTO() {
        return new Usuario();
    }

    private static final IPessoaDAO PESSOA_DAO;

    static {
        PESSOA_DAO = new PessoaDAO();
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementInserir() {
        return Arrays.asList(
                Arrays.asList("tipo", "username", "senha", "pk")
        );
    }

    /**
     * A pessoa referente ao usuário não deve existir antes de cria-lo, nesse caso haverá uma duplicata no banco de dados
     */
    @Override
    public Long inserir(Usuario usuario) throws PersistenceException {
        Long id = PESSOA_DAO.inserir(usuario);
        usuario.setId(id);

        super.inserir(usuario);
        return id;
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementAlterar() {
        return Arrays.asList(
                Arrays.asList("tipo", "username", "senha"),
                List.of("pk")
        );
    }

    @Override
    public boolean alterar(Usuario usuario) throws PersistenceException {
        PESSOA_DAO.alterar(usuario);

        return super.alterar(usuario);
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementRemover() {
        return List.of();
    }

    @Override
    public boolean remover(Usuario usuario) throws PersistenceException {
        return PESSOA_DAO.remover(usuario);
    }

    @Override
    protected List<List<String>> getColumnsResultSetListar() {
        return Arrays.asList(
                Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone", "tipo", "username", "senha", "pk")
        );
    }

    @Override
    protected List<String> getOrderByPriority() {
        return Arrays.asList("nome", "sobrenome");
    }

    @Override
    public List<Usuario> listar() throws PersistenceException {
        List<List<String>> columnsResultSet = getColumnsResultSetListar();

        List<String> allColumnsResultSet = helper.mergeLists(columnsResultSet.toArray(new List[0]));

        String sql = StringSqlDaoHelper.selectFromWhereOrderBy(Arrays.asList("nome", "sobrenome", "nascimento", "email",
                        "telefone", "tipo", "username", "senha", "usuario.pk"), Arrays.asList(getTable(), "pessoa"),
                Arrays.asList("pessoa.pk = usuario.pk"), getOrderByPriority());

        return (List<Usuario>) helper.listar(sql, allColumnsResultSet);
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementConsultar() {
        return Arrays.asList(
                List.of("pk")
        );
    }

    @Override
    protected List<List<String>> getColumnsResultSetConsultar() {
        return Arrays.asList(
                Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone", "tipo", "username", "senha", "pk")
        );
    }

    @Override
    public Usuario cosultarPorId(Long id) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = getColumnsPreparedStatementConsultar();

        List<List<String>> columnsResultSet = getColumnsResultSetConsultar();

        List<String> allColumnsPreparedStatement = helper.mergeLists(columnsPreparedStatement.toArray(new List[0]));
        List<String> allColumnsResultSet = helper.mergeLists(columnsResultSet.toArray(new List[0]));

        String sql = StringSqlDaoHelper.selectFromWhere(
                Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone", "tipo", "username", "senha", "usuario.pk"),
                Arrays.asList(getTable(), "pessoa"), Arrays.asList("usuario.pk = ?", "pessoa.pk = usuario.pk"));

        return (Usuario) helper.consultarPorId(id, sql, allColumnsPreparedStatement, allColumnsResultSet);
    }
}