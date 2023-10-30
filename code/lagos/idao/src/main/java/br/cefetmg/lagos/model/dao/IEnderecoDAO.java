package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Endereco;

import java.util.List;

public interface IEnderecoDAO extends IDAO {
    Long inserir(Endereco endereco) throws PersistenceException;
    
    boolean alterar(Endereco endereco) throws PersistenceException;
    
    boolean remover(Endereco endereco) throws PersistenceException;
    
    List<Endereco> listar() throws PersistenceException;

    Endereco cosultarPorId(Long id) throws PersistenceException;
}
