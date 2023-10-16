package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Estoquista;

public interface IEstoquistaDAO {
    
    boolean inserir(Estoquista etoquista) throws SQLException, ClassNotFoundException;
    
    boolean alterar(Estoquista estoquista) throws SQLException, ClassNotFoundException;
    
    boolean remover(Estoquista estoquista) throws SQLException, ClassNotFoundException;
    
    List<Estoquista> listar() throws SQLException, ClassNotFoundException;
}
