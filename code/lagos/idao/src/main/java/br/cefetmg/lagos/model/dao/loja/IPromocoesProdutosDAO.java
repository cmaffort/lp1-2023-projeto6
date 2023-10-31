package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.PromocoesProdutos;

import java.util.List;

public interface IPromocoesProdutosDAO extends IDAO {
    Long inserir(PromocoesProdutos promocoesProdutos) throws PersistenceException;

    boolean alterar(PromocoesProdutos promocoesProdutos) throws PersistenceException;

    boolean remover(PromocoesProdutos promocoesProdutos) throws PersistenceException;

    List<PromocoesProdutos> listar() throws PersistenceException;

    List<PromocoesProdutos> listar(DTO... related) throws PersistenceException;

    PromocoesProdutos consultarPorId(Long id) throws PersistenceException;
}
