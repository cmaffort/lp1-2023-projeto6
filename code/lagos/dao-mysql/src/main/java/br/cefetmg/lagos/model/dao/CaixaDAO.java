/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.lagos.model.dao;

import java.sql.*;
import br.cefetmg.lagos.model.dao.connection.ConnectionManager;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
/**
 *
 * @author migue
 */
public class CaixaDAO {
    
    public boolean inserirEstadoCaixa(boolean estadoCaixa) throws PersistenceException{
        try{
            Connection conexao = ConnectionManager.getInstance().getConnection();

            String querry = "INSERT INTO caixa (estado) VALUES (?)";

            PreparedStatement smt = conexao.prepareStatement(querry);
            smt.setBoolean(1, estadoCaixa);
            ResultSet rst = smt.executeQuery();

            rst.close();
            smt.close();
            conexao.close();

            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
