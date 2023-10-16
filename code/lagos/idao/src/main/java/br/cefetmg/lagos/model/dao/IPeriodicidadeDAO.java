package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Periodicidade;

public interface IPeriodicidadeDAO {
    
    boolean inserir(Periodicidade periodicidade) throws SQLException, ClassNotFoundException;
    
    boolean alterar(Periodicidade periodicidade) throws SQLException, ClassNotFoundException;
    
    boolean remover(Periodicidade periodicidade) throws SQLException, ClassNotFoundException;
    
    List<Periodicidade> listar() throws SQLException, ClassNotFoundException;
}
