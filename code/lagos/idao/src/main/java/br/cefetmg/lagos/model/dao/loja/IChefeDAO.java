package br.cefetmg.lagos.model.dao.loja;

import java.util.List;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.Chefe;

public interface IChefeDAO extends IDAO {
    Long inserir(Chefe chefe) throws PersistenceException;
    
    boolean alterar(Chefe chefe) throws PersistenceException;
    
    boolean remover(Chefe chefe) throws PersistenceException;
    
    List<Chefe> listar() throws PersistenceException;

    Chefe cosultarPorId(Long id) throws PersistenceException;
}
