package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dto.loja.Compra;

public class CompraDAO extends AbstractDAO<Compra> implements ICompraDAO {
    @Override
    protected Compra getDTO() {
        return new Compra();
    }
}
