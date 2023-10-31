package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.GerenteDeContrato;

import java.util.List;

public interface IGerenteDeContratoDAO extends IDAO {
    Long inserir(GerenteDeContrato gerenteDeContrato) throws PersistenceException;
    
    boolean alterar(GerenteDeContrato gerenteDeContrato) throws PersistenceException;
    
    boolean remover(GerenteDeContrato gerenteDeContrato) throws PersistenceException;
    
    List<GerenteDeContrato> listar() throws PersistenceException;

    GerenteDeContrato cosultarPorId(Long id) throws PersistenceException;
}
