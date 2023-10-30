package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.HistoricoVET;

public interface IHistoricoVETDAO {
    
    boolean inserir(HistoricoVET historico) throws SQLException, ClassNotFoundException;
    
    boolean alterar(HistoricoVET historico) throws SQLException, ClassNotFoundException;
    
    boolean remover(HistoricoVET historico) throws SQLException, ClassNotFoundException;
    
    List<HistoricoVET> listar() throws SQLException, ClassNotFoundException;
}