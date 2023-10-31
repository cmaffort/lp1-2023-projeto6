package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.Produto;

import java.util.List;

public interface IProdutoDAO extends IDAO {
    Long inserir(Produto produto) throws PersistenceException;
   
    boolean alterar(Produto produto) throws PersistenceException;
    
    boolean remover(Produto produto) throws PersistenceException;
    
    List<Produto> listar() throws PersistenceException;

    List<Produto> listar(DTO... related) throws PersistenceException;

    Produto consultarPorId(Long id) throws PersistenceException;
}
