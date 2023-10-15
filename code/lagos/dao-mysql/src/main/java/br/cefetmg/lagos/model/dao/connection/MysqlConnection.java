/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.lagos.model.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author miguel
 */
public class MysqlConnection implements ConnectionFactory{
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
