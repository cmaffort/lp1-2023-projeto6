package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.loja.IProdutoCompraDAO;
import br.cefetmg.lagos.model.dao.loja.ProdutoCompraDAO;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.loja.Produto;
import br.cefetmg.lagos.model.dto.loja.ProdutoCompra;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;

import java.util.List;

public class ManterProdutoCompra extends AbstractManterLojaModule<ProdutoCompra> implements IManterProdutoCompra {
    @Override
    protected IProdutoCompraDAO getDAO() {
        return new ProdutoCompraDAO();
    }

    @Override
    protected ProdutoCompra getDTOInstance() {
        return new ProdutoCompra();
    }

    @Override
    protected List<ProdutoCompra> pesquisarPorLojaNotRelated(Loja loja) throws PersistenceException, NegocioException {
        try {
            return pesquisarPorQualquerDosRelacionados((new ManterProduto()).pesquisarPorLoja(loja).toArray(new Produto[0]));
        } catch (NegocioException negocioException) {
            return List.of();
        }
    }
}
