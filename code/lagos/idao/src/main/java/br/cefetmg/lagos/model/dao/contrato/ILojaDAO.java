package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.contrato.Loja;

import java.util.List;

public interface ILojaDAO extends IDAO {
    Long inserir(Loja loja) throws PersistenceException;
    
    boolean alterar(Loja loja) throws PersistenceException;
    
    boolean remover(Loja loja) throws PersistenceException;
    
    List<Loja> listar() throws PersistenceException;

    List<Loja> listar(DTO... related) throws PersistenceException;

    Loja consultarPorId(Long id) throws PersistenceException;
}
