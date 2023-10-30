package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.Item;

import java.util.List;

public interface IItemDAO extends IDAO {
    Long inserir(Item item) throws PersistenceException;
    
    boolean alterar(Item item) throws PersistenceException;
    
    boolean remover(Item item) throws PersistenceException;
    
    List<Item> listar() throws PersistenceException;

    Item cosultarPorId(Long id) throws PersistenceException;
}
