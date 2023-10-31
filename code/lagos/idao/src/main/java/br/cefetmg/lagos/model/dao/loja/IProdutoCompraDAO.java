package br.cefetmg.lagos.model.dao.loja;

import java.util.List;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.ProdutoCompra;

public interface IProdutoCompraDAO extends IDAO {
    Long inserir(ProdutoCompra produtoCompra) throws PersistenceException;
    
    boolean alterar(ProdutoCompra produtoCompra) throws PersistenceException;
    
    boolean remover(ProdutoCompra produtoCompra) throws PersistenceException;
    
    List<ProdutoCompra> listar() throws PersistenceException;

    ProdutoCompra cosultarPorId(Long id) throws PersistenceException;
}
