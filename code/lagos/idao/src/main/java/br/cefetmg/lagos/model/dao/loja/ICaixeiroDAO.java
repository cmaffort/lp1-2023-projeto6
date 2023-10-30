package br.cefetmg.lagos.model.dao.loja;

import java.util.List;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.Caixeiro;

public interface ICaixeiroDAO extends IDAO {
    Long inserir(Caixeiro caixeiro) throws PersistenceException;
    
    boolean alterar(Caixeiro caixeiro) throws PersistenceException;
    
    boolean remover(Caixeiro caixeiro) throws PersistenceException;
    
    List<Caixeiro> listar() throws PersistenceException;

    Caixeiro cosultarPorId(Long id) throws PersistenceException;
}
