package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Contrato;

import java.util.List;

public interface IContratoDAO extends IDAO {
    Long inserir(Contrato contrato) throws PersistenceException;
    
    boolean alterar(Contrato contrato) throws PersistenceException;
    
    boolean remover(Contrato contrato)  throws PersistenceException;
    
    List<Contrato> listar() throws PersistenceException;

    Contrato consultarPorId(Long id) throws PersistenceException;
}
