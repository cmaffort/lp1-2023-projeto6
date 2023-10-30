package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.Estoquista;

import java.util.List;

public interface IEstoquistaDAO extends IDAO {
    Long inserir(Estoquista etoquista) throws PersistenceException;
    
    boolean alterar(Estoquista estoquista) throws PersistenceException;
    
    boolean remover(Estoquista estoquista) throws PersistenceException;
    
    List<Estoquista> listar() throws PersistenceException;

    Estoquista cosultarPorId(Long id) throws PersistenceException;
}
