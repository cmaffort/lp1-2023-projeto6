package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.loja.IProdutoDAO;
import br.cefetmg.lagos.model.dao.loja.ProdutoDAO;
import br.cefetmg.lagos.model.dto.loja.Produto;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;

public class ManterProduto extends AbstractManterLojaModule<Produto> implements IManterProduto {
    @Override
    protected IProdutoDAO getDAO() {
        return new ProdutoDAO();
    }

    @Override
    protected Produto getDTOInstance() {
        return new Produto();
    }
}
