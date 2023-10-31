package br.cefetmg.lagos.model.dao;

import java.util.List;
import br.cefetmg.lagos.model.dto.Periodicidade;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;

public interface IPeriodicidadeDAO extends IDAO {
    Long inserir(Periodicidade periodicidade) throws PersistenceException;
    
    boolean alterar(Periodicidade periodicidade) throws PersistenceException;
    
    boolean remover(Periodicidade periodicidade) throws PersistenceException;
    
    List<Periodicidade> listar() throws PersistenceException;

    Periodicidade cosultarPorId(Long id) throws PersistenceException;
}
