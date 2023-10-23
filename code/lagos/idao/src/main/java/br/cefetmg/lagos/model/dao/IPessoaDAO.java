package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Pessoa;

public interface IPessoaDAO {
    
    Long inserir(Pessoa pessoa)  throws PersistenceException;

    boolean alterar(Pessoa pessoa) throws PersistenceException;
    
    boolean remover(Pessoa pessoa) throws PersistenceException;
    
    List<Pessoa> listar() throws PersistenceException;

    Pessoa cosultarPorId(Long id) throws PersistenceException;
}
