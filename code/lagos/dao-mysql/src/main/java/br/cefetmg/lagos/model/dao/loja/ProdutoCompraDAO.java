package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dto.loja.ProdutoCompra;

public class ProdutoCompraDAO extends AbstractDAO<ProdutoCompra> implements IProdutoCompraDAO {
    @Override
    protected ProdutoCompra getDTO() {
        return new ProdutoCompra();
    }
}
