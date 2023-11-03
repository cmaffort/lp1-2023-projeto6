package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.PromocoesDeFidelidadeProdutos;

import java.util.List;

public class PromocoesDeFidelidadeProdutosDAO extends AbstractDAO<PromocoesDeFidelidadeProdutos> implements IPromocoesDeFidelidadeProdutosDAO {
    @Override
    protected PromocoesDeFidelidadeProdutos getDTO() {
        return new PromocoesDeFidelidadeProdutos();
    }
}
