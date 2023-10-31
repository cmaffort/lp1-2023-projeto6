package br.cefetmg.lagos.model.dao.loja;

import java.util.List;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.FluxoDeCaixa;

public interface IFluxoDeCaixaDAO extends IDAO {
    boolean inserir(FluxoDeCaixa fluxoDeCaixa) throws PersistenceException;
    
    boolean alterar(FluxoDeCaixa fluxoDeCaixa) throws PersistenceException;
    
    boolean remover(FluxoDeCaixa fluxoDeCaixa) throws PersistenceException;
    
    List<FluxoDeCaixa> listar() throws PersistenceException;

    List<FluxoDeCaixa> listar(DTO... related) throws PersistenceException;

    FluxoDeCaixa consultarPorId(Long id) throws PersistenceException;
}