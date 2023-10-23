package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.connections.ConnectionManager;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO implements IPessoaDAO {
    private void setAllStatementValues(Pessoa pessoa, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, pessoa.getNome());
        preparedStatement.setString(2, pessoa.getSobrenome());
        preparedStatement.setDate(3, pessoa.getNascimento());
        preparedStatement.setString(4, pessoa.getEmail());
        preparedStatement.setLong(5, pessoa.getTelefone());
    }

    private Pessoa getPessoaFrom(ResultSet resultSet) throws SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(resultSet.getLong("pk"));
        pessoa.setNome(resultSet.getString("nome"));
        pessoa.setSobrenome(resultSet.getString("sobrenome"));
        pessoa.setNascimento(resultSet.getDate("nascimento"));
        pessoa.setEmail(resultSet.getString("email"));
        pessoa.setTelefone(resultSet.getLong("telefone"));
        return pessoa;
    }

    @Override
    public Long inserir(Pessoa pessoa) throws PersistenceException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql =
                    "INSERT INTO pessoa (nome, sobrenome, nascimento, email, telefone) " +
                    "VALUES (?, ?, ?, ?, ?);" +
                    "SELECT LAST_INSERT_ID();";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            setAllStatementValues(pessoa, preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            Long id = null;
            if (resultSet.next()) {
                id = resultSet.getLong("pk");
                pessoa.setId(id);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean alterar(Pessoa pessoa) throws PersistenceException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql =
                    "UPDATE pessoa " +
                    "SET nome = ?, sobrenome = ?, nascimento = ?, email = ?, telefone = ? " +
                    "WHERE pk = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            setAllStatementValues(pessoa, preparedStatement);
            preparedStatement.setLong(6, pessoa.getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean remover(Pessoa pessoa) throws PersistenceException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM pessoa WHERE pk = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, pessoa.getId());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Pessoa> listar() throws PersistenceException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM pessoa ORDER BY nome, sobrenome;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Pessoa> pessoas = null;
            if (resultSet.next()) {
                pessoas = new ArrayList<>();
                do {
                    pessoas.add(getPessoaFrom(resultSet));
                } while (resultSet.next());
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return pessoas;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException(e.getMessage(), e);
        }
    }

    @Override
    public Pessoa cosultarPorId(Long id) throws PersistenceException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM pessoa WHERE pk = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            Pessoa pessoa = null;
            if (resultSet.next())
                pessoa = getPessoaFrom(resultSet);

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return pessoa;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException(e.getMessage(), e);
        }
    }
}
