package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Contratante;

public interface IContratanteDAO {
    
    boolean inserir(Contratante contratante) throws SQLException, ClassNotFoundException;
    
    boolean alterar(Contratante contratante) throws SQLException, ClassNotFoundException;
    
    boolean remover(Contratante contratante) throws SQLException, ClassNotFoundException;
    
    List<Contratante> listar() throws SQLException, ClassNotFoundException;
}
