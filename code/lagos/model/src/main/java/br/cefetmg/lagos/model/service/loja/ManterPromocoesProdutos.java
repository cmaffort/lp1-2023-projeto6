package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.loja.IPromocoesProdutosDAO;
import br.cefetmg.lagos.model.dao.loja.PromocoesProdutosDAO;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.loja.Produto;
import br.cefetmg.lagos.model.dto.loja.PromocoesProdutos;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;

import java.util.List;

public class ManterPromocoesProdutos extends AbstractManterLojaModule<PromocoesProdutos> implements IManterPromocoesProdutos {
    @Override
    protected IPromocoesProdutosDAO getDAO() {
        return new PromocoesProdutosDAO();
    }

    @Override
    protected PromocoesProdutos getDTOInstance() {
        return new PromocoesProdutos();
    }

    @Override
    protected List<PromocoesProdutos> pesquisarPorLojaNotRelated(Loja loja) throws PersistenceException, NegocioException {
        try {
            return pesquisarPorQualquerDosRelacionados((new ManterProduto()).pesquisarPorLoja(loja).toArray(new Produto[0]));
        } catch (NegocioException negocioException) {
            return List.of();
        }
    }
}
