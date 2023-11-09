package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.loja.ICompraDAO;
import br.cefetmg.lagos.model.dao.loja.CompraDAO;
import br.cefetmg.lagos.model.dto.loja.Compra;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;

public class ManterCompra extends AbstractManterLojaModule<Compra> implements IManterCompra {
    @Override
    protected ICompraDAO getDAO() {
        return new CompraDAO();
    }

    @Override
    protected Compra getDTOInstance() {
        return new Compra();
    }
}
