package br.cefetmg.lagos.model.dao.loja;

import java.util.List;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.Cliente;

public interface IClienteDAO extends IDAO {
    Long inserir(Cliente cliente) throws PersistenceException;
    
    boolean alterar(Cliente cliente) throws PersistenceException;
    
    boolean remover(Cliente cliente) throws PersistenceException;
    
    List<Cliente> listar() throws PersistenceException;

    Cliente cosultarPorId(Long id) throws PersistenceException;
}
