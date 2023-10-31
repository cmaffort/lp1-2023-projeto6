package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.Compra;

import java.util.List;

public interface ICompraDAO extends IDAO {
    Long inserir(Compra compra) throws PersistenceException;
    
    boolean alterar(Compra compra) throws PersistenceException;
    
    boolean remover(Compra compra) throws PersistenceException;
    
    List<Compra> listar() throws PersistenceException;

    Compra consultarPorId(Long id) throws PersistenceException;
}