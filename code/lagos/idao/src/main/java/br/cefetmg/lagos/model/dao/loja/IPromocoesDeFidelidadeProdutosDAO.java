package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.PromocoesDeFidelidadeProdutos;
import br.cefetmg.lagos.model.dto.loja.PromocoesProdutos;

import java.util.List;

public interface IPromocoesDeFidelidadeProdutosDAO extends IDAO {
    Long inserir(PromocoesDeFidelidadeProdutos promocoesDeFidelidadeProdutos) throws PersistenceException;

    boolean alterar(PromocoesDeFidelidadeProdutos promocoesDeFidelidadeProdutos) throws PersistenceException;

    boolean remover(PromocoesDeFidelidadeProdutos promocoesDeFidelidadeProdutos) throws PersistenceException;

    List<PromocoesDeFidelidadeProdutos> listar() throws PersistenceException;

    List<PromocoesDeFidelidadeProdutos> listar(DTO... related) throws PersistenceException;

    PromocoesDeFidelidadeProdutos consultarPorId(Long id) throws PersistenceException;
}
