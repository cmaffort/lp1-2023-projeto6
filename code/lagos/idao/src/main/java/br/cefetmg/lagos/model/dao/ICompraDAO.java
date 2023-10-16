package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Compra;

public interface ICompraDAO{
    
    boolean inserir(Compra compra) throws SQLException, ClassNotFoundException;
    
    boolean alterar(Compra compra) throws SQLException, ClassNotFoundException;
    
    boolean remover(Compra compra) throws SQLException, ClassNotFoundException;
    
    List<Compra> listar() throws SQLException, ClassNotFoundException;
}