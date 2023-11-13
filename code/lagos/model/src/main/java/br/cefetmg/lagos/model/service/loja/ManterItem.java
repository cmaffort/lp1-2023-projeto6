package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.loja.IItemDAO;
import br.cefetmg.lagos.model.dao.loja.ItemDAO;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.loja.Item;
import br.cefetmg.lagos.model.dto.loja.Produto;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.contrato.ManterLoja;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;

import java.util.List;

public class ManterItem extends AbstractManterLojaModule<Item> implements IManterItem {
    @Override
    protected IItemDAO getDAO() {
        return new ItemDAO();
    }

    @Override
    protected Item getDTOInstance() {
        return new Item();
    }

    @Override
    protected List<Item> pesquisarPorLojaNotRelated(Loja loja) throws PersistenceException, NegocioException {
        try {
            List<Produto> pl = (new ManterProduto()).pesquisarPorLoja(loja);
            return pesquisarPorQualquerDosRelacionados((new ManterProduto()).pesquisarPorLoja(loja).toArray(new Produto[0]));
        } catch (NegocioException negocioException) {
            return List.of();
        }
    }
}
