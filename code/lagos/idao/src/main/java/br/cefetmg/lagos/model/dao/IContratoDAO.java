package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Contrato;

public interface IContratoDAO {
    
    boolean inserir(Contrato contrato) throws SQLException, ClassNotFoundException;
    
    boolean alterar(Contrato contrato) throws SQLException, ClassNotFoundException;
    
    boolean remover(Contrato contrato)  throws SQLException, ClassNotFoundException;
    
    List<Contrato> listar() throws SQLException, ClassNotFoundException;
}
