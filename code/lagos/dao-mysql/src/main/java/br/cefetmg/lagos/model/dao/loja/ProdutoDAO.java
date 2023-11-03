package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dto.loja.Produto;

public class ProdutoDAO extends AbstractDAO<Produto> implements IProdutoDAO {
    @Override
    protected Produto getDTO() {
        return new Produto();
    }
}
