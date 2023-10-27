package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.connections.ConnectionManager;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.util.StringSql;
import br.cefetmg.lagos.model.dto.DTO;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsuarioDAO extends DAO implements IUsuarioDAO {
    private final IPessoaDAO pessoaDAO;

    public UsuarioDAO() {
        super();
        pessoaDAO = new PessoaDAO();
    }

    @Override
    protected String getTable() {
        return "usuario";
    }

    @Override
    protected Class<? extends DTO> getDTO() {
        return Usuario.class;
    }

    @Override
    protected List<String> getColumnsInsert() {
        return Arrays.asList("tipo", "username", "senha", "pk");
    }

    @Override
    public Long inserir(Usuario usuario) throws PersistenceException {
        Long id = pessoaDAO.inserir(usuario);
        if (id != null)
            usuario.setId(id);
        return super.inserir(usuario);
    }

    protected List<String> getColumnsUpdateSet() {
        return Arrays.asList("tipo", "username", "senha");
    }

    protected List<String> getColumnsWhere() {
        return List.of("pk");
    }

    @Override
    public boolean alterar(Usuario usuario) throws PersistenceException {
        pessoaDAO.alterar(usuario);
        return super.alterar(usuario);
    }

    @Override
    public boolean remover(Usuario usuario) throws PersistenceException {
        return pessoaDAO.remover(usuario);
    }

    @Override
    protected List<String> getColumnsOrderBy() {
        return List.of("(" + StringSql.bigStatement(StringSql.select(Arrays.asList("nome", "sobrenome")),
                StringSql.from("pessoa")) + ")");
    }

    @Override
    protected List<String> getColumnsSelect() {
        return Arrays.asList("tipo", "username", "senha", "pk", "nome", "sobrenome", "nascimento", "email", "telefone");
    }

    @Override
    protected String getSelectStatement(List<String> columnsSelect) {
        return StringSql.select(columnsSelect);
    }

    @Override
    protected String getFromStatement() {
        return StringSql.from(Arrays.asList(getTable(), "pessoas"));
    }

    @Override
    public List<Usuario> listar() throws PersistenceException {
        return (List<Usuario>) super.listar();
    }

    @Override
    public Pessoa cosultarPorId(Long id) throws PersistenceException {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        return (Pessoa) super.cosultarPorId(id, pessoa);
    }
    // ..

    @Override
    public List<Usuario> listar() throws PersistenceException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            List<String> columnsOrderBy = Arrays.asList(StringSql.bigStatement(
                    StringSql.select(List.of("nome", "sobrenome")), StringSql.from("pessoa")
            ));

            String sql = StringSql.bigStatement(StringSql.selectAll(), StringSql.from(getTable()),
                    StringSql.orderBy(columnsOrderBy));

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Usuario> usuarios = null;
            if (resultSet.next()) {
                usuarios = new ArrayList<>();
                do {
                    Usuario usuario = (Usuario) getWithValues(resultSet, getAllColumns());
                    usuario.set
                    usuarios.add((Usuario) getWithValues(resultSet, getAllColumns()));
                    usuarios.
                } while (resultSet.next());
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return usuarios;
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }

    @Override
    public Usuario cosultarPorId(Long id) throws PersistenceException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            List<String> columnsWhere = List.of("pk");

            String sql = StringSql.bigStatement(StringSql.selectAll(), StringSql.from(getTable()),
                    StringSql.whereEq(columnsWhere));

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Pessoa pessoa = new Pessoa();
            pessoa.setId(id);
            setStatementValuesFor(pessoa, preparedStatement, columnsWhere);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
                insertValues(pessoa, resultSet, getAllColumns());
            else
                pessoa = null;

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return pessoa;
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }
}
