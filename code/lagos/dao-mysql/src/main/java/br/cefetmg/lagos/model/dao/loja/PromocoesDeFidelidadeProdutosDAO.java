package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dto.loja.PromocoesDeFidelidadeProdutos;

public class PromocoesDeFidelidadeProdutosDAO extends AbstractDAO<PromocoesDeFidelidadeProdutos> implements IPromocoesDeFidelidadeProdutosDAO {
    @Override
    protected PromocoesDeFidelidadeProdutos getDTO() {
        return new PromocoesDeFidelidadeProdutos();
    }
}
