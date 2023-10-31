package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.Venda;

import java.util.List;

public interface IVendaDAO extends IDAO {
    Long inserir(Venda venda) throws PersistenceException;
    
    boolean alterar(Venda venda) throws PersistenceException;
    
    boolean remover(Venda venda) throws PersistenceException;
    
    List<Venda> listar() throws PersistenceException;

    List<Venda> listar(DTO... related) throws PersistenceException;

    Double sum() throws PersistenceException;

    Double sum(DTO related) throws PersistenceException;

    Venda consultarPorId(Long id) throws PersistenceException;
}
