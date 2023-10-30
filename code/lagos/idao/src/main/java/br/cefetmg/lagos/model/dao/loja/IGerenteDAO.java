package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.Gerente;

import java.util.List;

public interface IGerenteDAO extends IDAO {
    
    boolean inserir(Gerente gerente) throws PersistenceException;
    
    boolean alterar(Gerente gerente) throws PersistenceException;
    
    boolean remover(Gerente gerente) throws PersistenceException;
    
    List<Gerente> listar() throws PersistenceException;

    Gerente cosultarPorId(Long id) throws PersistenceException;
}
