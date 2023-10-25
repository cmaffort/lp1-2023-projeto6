package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.connections.ConnectionManager;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO {
    private final IPessoaDAO pessoaDAO;

    public UsuarioDAO() {
        pessoaDAO = new PessoaDAO();
    }

    private void setAllStatementValues(Usuario usuario, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, usuario.getTipo().ordinal());
        preparedStatement.setString(2, usuario.getUsername());
        preparedStatement.setString(3, usuario.getSenha());
    }

    @Override
    public Long inserir(Usuario usuario) throws PersistenceException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            Long id = pessoaDAO.inserir(usuario);

            String sql =
                    "INSERT INTO usuario (tipo, username, senha, pk) " +
                    "VALUES (?, ?, ?, ?);";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            setAllStatementValues(usuario, preparedStatement);
            preparedStatement.setLong(4, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean alterar(Usuario usuario) throws PersistenceException {
        return false;
    }

    @Override
    public boolean remover(Usuario usuario) throws PersistenceException {
        return false;
    }

    @Override
    public List<Usuario> listar() throws PersistenceException {
        return null;
    }

    @Override
    public Usuario cosultarPorId(Long id) throws PersistenceException {
        return null;
    }
}
