/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao.connection;

import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author miguel
 */
public interface ConnectionFactory {
    public Connection getConnection() throws SQLException, ClassNotFoundException;
    public boolean close() throws SQLException;
}
