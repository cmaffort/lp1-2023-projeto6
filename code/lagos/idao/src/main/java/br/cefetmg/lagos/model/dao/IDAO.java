package br.cefetmg.lagos.model.dao;

import java.util.List;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.DTO;

public interface IDAO {
    Long inserir(DTO pessoa)  throws PersistenceException;

    boolean alterar(DTO pessoa) throws PersistenceException;

    boolean remover(DTO pessoa) throws PersistenceException;

    List<? extends DTO> listar() throws PersistenceException;

    DTO cosultarPorId(Long id) throws PersistenceException;
}
