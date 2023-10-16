package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Chefe;

public interface IChefeDAO {
    
    boolean inserir(Chefe chefe) throws SQLException, ClassNotFoundException;
    
    boolean alterar(Chefe chefe) throws SQLException, ClassNotFoundException;
    
    boolean remover(Chefe chefe) throws SQLException, ClassNotFoundException;
    
    List<Chefe> listar() throws SQLException, ClassNotFoundException;
}
