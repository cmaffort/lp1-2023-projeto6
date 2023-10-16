package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Item;

public interface IItemDAO{
    
    boolean inserir(Item item) throws SQLException, ClassNotFoundException;
    
    boolean alterar(Item item) throws SQLException, ClassNotFoundException;
    
    boolean remover(Item item) throws SQLException, ClassNotFoundException;
    
    List<Item> listar() throws SQLException, ClassNotFoundException;
}
