package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.Promocao;

import java.util.List;

public interface IPromocaoDAO extends IDAO {
    Long inserir(Promocao promocao) throws PersistenceException;
    
    boolean alterar(Promocao promocao) throws PersistenceException;
    
    boolean remover(Promocao promocao) throws PersistenceException;
    
    List<Promocao> listar() throws PersistenceException;

    Promocao consultarPorId(Long id) throws PersistenceException;
}
