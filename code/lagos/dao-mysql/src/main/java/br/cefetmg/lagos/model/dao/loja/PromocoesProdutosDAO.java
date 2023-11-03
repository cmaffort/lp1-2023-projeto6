package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.PromocoesProdutos;

import java.util.List;

public class PromocoesProdutosDAO extends AbstractDAO<PromocoesProdutos> implements IPromocoesProdutosDAO {
    @Override
    protected PromocoesProdutos getDTO() {
        return new PromocoesProdutos();
    }
}
