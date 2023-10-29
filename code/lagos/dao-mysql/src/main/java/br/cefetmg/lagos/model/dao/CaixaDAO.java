package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.connections.ConnectionManager;
import br.cefetmg.lagos.model.dto.Caixa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CaixaDAO implements ICaixaDAO {

    public CaixaDAO() {}
    
    private Caixa getCaixaFrom(ResultSet resultSet) throws SQLException {
        Caixa caixa = new Caixa();
        caixa.setId(resultSet.getLong("pk"));
        caixa.setAberto(resultSet.getBoolean("aberto"));
        caixa.setDinheiroEmCaixa(resultSet.getDouble("DinheiroEmCaixa"));
        //RESOLVER PROBLEMAS NESSES 3 SETS
        caixa.setCaixeiro(null);
        caixa.setFluxoTotalDeCaixa(null);
        caixa.setLoja(null);
        return caixa;
    }
    
    private void setAllStatementValues(Caixa caixa, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setBoolean(1, caixa.isAberto());
        preparedStatement.setDouble(2, caixa.getDinheiroEmCaixa());
        preparedStatement.setString(3, caixa.getCaixeiro().getNome());
        preparedStatement.setLong(4, caixa.getFluxoTotalDeCaixa().getId());
        preparedStatement.setLong(5, caixa.getLoja().getEndereco().getCep());
    }
    
    @Override
    public long inserir(Caixa caixa) throws SQLException, ClassNotFoundException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String sql =
                    "INSERT INTO caixa (Aberto, DinheiroEmCaixa, Caixeiro, FluxoTotalDeCaixa, Loja) VALUES (?, ?, ?, ?, ?); SELECT LAST_INSERT_ID();";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            setAllStatementValues(caixa, preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();
            Long id = null;
            if (resultSet.next()) {
                id = resultSet.getLong("pk");
                caixa.setId(id);
            }
            resultSet.close();
            
            preparedStatement.close();
            connection.close();

            return id;
            
           
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException(e.getMessage(), e);
        }
    }

    @Override
    public boolean alterar(Caixa caixa) throws SQLException, ClassNotFoundException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String sql =
                    "UPDATE pessoa SET nome = ?, sobrenome = ?, nascimento = ?, email = ?, telefone = ? WHERE pk = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            setAllStatementValues(caixa, preparedStatement);
            preparedStatement.setLong(6, caixa.getId());
            preparedStatement.executeUpdate();

            
            preparedStatement.close();
            connection.close();

            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException(e.getMessage(), e);
        }
    }

    @Override
    public boolean remover(Caixa caixa) throws SQLException, ClassNotFoundException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM pessoa WHERE pk = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, caixa.getId());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException(e.getMessage(), e);
        }
    }

    @Override
    public List<Caixa> listar() throws SQLException, ClassNotFoundException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM pessoa ORDER BY nome, sobrenome;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Caixa> caixas = null;
            if (resultSet.next()) {
                caixas = new ArrayList<>();
                do {
                    caixas.add(getCaixaFrom(resultSet));
                } while (resultSet.next());
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return caixas;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException(e.getMessage(), e);
        }
    }
    
    @Override
    public Caixa cosultarPorId(Long id) throws ClassNotFoundException {
       try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM pessoa WHERE pk = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            Caixa pessoa = null;
            if (resultSet.next())
                pessoa = getCaixaFrom(resultSet);

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return pessoa;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException(e.getMessage(), e);
        }
       
    }
    
}
