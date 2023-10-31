package br.cefetmg.lagos.model.dao.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection implements ConnectionFactory {
    
    private static Connection connection;
    private final static String driver;
    private final static String url;
    private final static String user;
    private final static String password;

    static {
        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/lagos";
        user = "admin";
        password = "admin";
    }

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            return connection;
    }

    public MySQLConnection() {}

    @Override
    public boolean close() throws SQLException {
        try {
            connection.close();
            return true;
        } catch(SQLException e) {
            return false;
        }
    }
}