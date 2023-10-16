package br.cefetmg.lagos.model.dao.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection implements ConnectionFactory{
    
    private static Connection connection;    

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException{
            String driver = "com.myswl.jdbc.Driver";
            String url = "jdbc:mysql://ip/lagos";
            String user = "root";
            String password = "1234";

            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            return connection;
    }

    @Override
    public boolean close() throws SQLException{
        try{
            connection.close();
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}