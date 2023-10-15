/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.lagos.model.dao.connection;
import java.sql.SQLException;
import java.sql.Connection;
/**
 *
 * @author miguel
 */
public class ConnectionManager {
    private static ConnectionManager cm;
    private static ConnectionFactory cf;
    
    private ConnectionManager(){
        ConnectionManager.cf = new MysqlConnection();
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
