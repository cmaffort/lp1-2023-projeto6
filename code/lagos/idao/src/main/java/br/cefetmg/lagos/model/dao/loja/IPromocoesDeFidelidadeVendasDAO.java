package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.PromocoesDeFidelidadeVendas;

import java.util.List;

public interface IPromocoesDeFidelidadeVendasDAO extends IDAO {
    Long inserir(PromocoesDeFidelidadeVendas promocoesDeFidelidadeVendas) throws PersistenceException;

    boolean alterar(PromocoesDeFidelidadeVendas promocoesDeFidelidadeVendas) throws PersistenceException;

    boolean remover(PromocoesDeFidelidadeVendas promocoesDeFidelidadeVendas) throws PersistenceException;

    List<PromocoesDeFidelidadeVendas> listar() throws PersistenceException;

    List<PromocoesDeFidelidadeVendas> listar(DTO... related) throws PersistenceException;

    PromocoesDeFidelidadeVendas consultarPorId(Long id) throws PersistenceException;
}
