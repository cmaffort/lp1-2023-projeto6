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
        caixa.setCaixeiro(resultSet.getString("Caixeiro"));
        caixa.setFluxoTotalDeCaixa(resultSet.getDouble("FluxoTotalDeCaixa"));
        caixa.setLoja(resultSet.getLong("Loja"));
        return caixa;
    }
    
    private void setAllStatementValues(Caixa caixa, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setBoolean(1, caixa.isAberto());
        preparedStatement.setDouble(2, caixa.getDinheiroEmCaixa());
        preparedStatement.setString(3, caixa.getCaixeiro());
        preparedStatement.setDouble(4, caixa.getFluxoTotalDeCaixa());
        preparedStatement.setLong(5, caixa.getLoja());
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
                    "UPDATE caixa SET Aberto = ?, DinheiroEmCaixa = ?, Caixeiro = ?, FluxoTotalDeCaixa = ?, Loja = ? WHERE pk = ?;";
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

            String sql = "DELETE FROM caixa WHERE pk = ?;";

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

            String sql = "SELECT * FROM caixa ORDER BY Loja, Aberto, Caixeiro;";

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

            String sql = "SELECT * FROM caixa WHERE pk = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            Caixa caixa = null;
            if (resultSet.next())
                caixa = getCaixaFrom(resultSet);

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return caixa;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException(e.getMessage(), e);
        }
       
    }
    
}
