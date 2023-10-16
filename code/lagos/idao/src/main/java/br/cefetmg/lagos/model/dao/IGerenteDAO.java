package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Gerente;

public interface IGerenteDAO {
    
    boolean inserir(Gerente gerente) throws SQLException, ClassNotFoundException;
    
    boolean alterar(Gerente gerente) throws SQLException, ClassNotFoundException;
    
    boolean remover(Gerente gerente) throws SQLException, ClassNotFoundException;
    
    List<Gerente> listar() throws SQLException, ClassNotFoundException;
}
