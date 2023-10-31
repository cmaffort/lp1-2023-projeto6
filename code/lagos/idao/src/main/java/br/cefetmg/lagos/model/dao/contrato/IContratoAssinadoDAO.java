package br.cefetmg.lagos.model.dao.contrato;

import java.util.List;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;

public interface IContratoAssinadoDAO extends IDAO {
    Long inserir(ContratoAssinado contratoAssinado) throws PersistenceException;
    
    boolean alterar(ContratoAssinado contratoAssinado) throws PersistenceException;
    
    boolean remover(ContratoAssinado contratoAssinado) throws PersistenceException;
    
    List<ContratoAssinado> listar() throws PersistenceException;

    List<ContratoAssinado> listar(DTO... related) throws PersistenceException;

    ContratoAssinado consultarPorId(Long id) throws PersistenceException;

    ContratoAssinado consultarPor(DTO... related) throws PersistenceException;
}
