package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.Vendedor;

import java.util.List;

public interface IVendedorDAO extends IDAO {
    Long inserir(Vendedor vendedor) throws PersistenceException;
    
    boolean alterar(Vendedor vendedor) throws PersistenceException;
    
    boolean remover(Vendedor vendedor) throws PersistenceException;
    
    List<Vendedor> listar() throws PersistenceException;

    Vendedor cosultarPorId(Long id) throws PersistenceException;
}
