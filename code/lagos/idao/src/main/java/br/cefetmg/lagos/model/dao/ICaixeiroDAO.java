package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Caixeiro;

public interface ICaixeiroDAO {
    
    boolean inserir(Caixeiro caixeiro) throws SQLException, ClassNotFoundException;
    
    boolean alterar(Caixeiro caixeiro) throws SQLException, ClassNotFoundException;
    
    boolean remover(Caixeiro caixeiro) throws SQLException, ClassNotFoundException;
    
    List<Caixeiro> listar() throws SQLException, ClassNotFoundException;
    
}
