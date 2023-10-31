package br.cefetmg.lagos.model.dao;

import java.util.List;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Cartao;
import br.cefetmg.lagos.model.dto.base.DTO;

public interface ICartaoDAO extends IDAO {
    Long inserir(Cartao cartao) throws PersistenceException;
    
    boolean alterar(Cartao cartao) throws PersistenceException;
    
    boolean remover(Cartao cartao) throws PersistenceException;
    
    List<Cartao> listar() throws PersistenceException;

    List<Cartao> listar(DTO... related) throws PersistenceException;

    Cartao consultarPorId(Long id) throws PersistenceException;
}
