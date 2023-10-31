package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.HistoricoVET;

import java.util.List;

public interface IHistoricoVETDAO extends IDAO {
    
    boolean inserir(HistoricoVET historicoVET) throws PersistenceException;
    
    boolean alterar(HistoricoVET historicoVET) throws PersistenceException;
    
    boolean remover(HistoricoVET historicoVET) throws PersistenceException;
    
    List<HistoricoVET> listar() throws PersistenceException;

    HistoricoVET consultarPorId(Long id) throws PersistenceException;
}