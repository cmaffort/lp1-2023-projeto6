package br.cefetmg.lagos.model.dao.connections;

import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionManager {
    
    private static ConnectionManager cm;
    private static ConnectionFactory cf;

    private ConnectionManager(){
        ConnectionManager.cf = new MySQLConnection();
    }

    public static ConnectionManager getInstance(){
        if(cm == null)
            cm = new ConnectionManager();

        return cm;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException{
        return ConnectionManager.cf.getConnection();
    }

}