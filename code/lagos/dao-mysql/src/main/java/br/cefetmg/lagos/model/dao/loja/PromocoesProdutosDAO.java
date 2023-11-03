package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dto.loja.PromocoesProdutos;

public class PromocoesProdutosDAO extends AbstractDAO<PromocoesProdutos> implements IPromocoesProdutosDAO {
    @Override
    protected PromocoesProdutos getDTO() {
        return new PromocoesProdutos();
    }
}
