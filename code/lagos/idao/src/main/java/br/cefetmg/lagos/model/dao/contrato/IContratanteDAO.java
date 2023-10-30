package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Contratante;

import java.util.List;

public interface IContratanteDAO extends IDAO {
    Long inserir(Contratante contratante) throws PersistenceException;
    
    boolean alterar(Contratante contratante) throws PersistenceException;
    
    boolean remover(Contratante contratante) throws PersistenceException;
    
    List<Contratante> listar() throws PersistenceException;

    Contratante cosultarPorId(Long id) throws PersistenceException;
}
