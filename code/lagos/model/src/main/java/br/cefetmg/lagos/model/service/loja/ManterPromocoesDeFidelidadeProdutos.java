package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.loja.IPromocoesDeFidelidadeProdutosDAO;
import br.cefetmg.lagos.model.dao.loja.PromocoesDeFidelidadeProdutosDAO;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.loja.Produto;
import br.cefetmg.lagos.model.dto.loja.PromocoesDeFidelidadeProdutos;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;

import java.util.List;

public class ManterPromocoesDeFidelidadeProdutos extends AbstractManterLojaModule<PromocoesDeFidelidadeProdutos> implements IManterPromocoesDeFidelidadeProdutos {
    @Override
    protected IPromocoesDeFidelidadeProdutosDAO getDAO() {
        return new PromocoesDeFidelidadeProdutosDAO();
    }

    @Override
    protected PromocoesDeFidelidadeProdutos getDTOInstance() {
        return new PromocoesDeFidelidadeProdutos();
    }

    @Override
    protected List<PromocoesDeFidelidadeProdutos> pesquisarPorLojaNotRelated(Loja loja) throws PersistenceException, NegocioException {
        try {
            return pesquisarPorQualquerDosRelacionados((new ManterProduto()).pesquisarPorLoja(loja).toArray(new Produto[0]));
        } catch (NegocioException negocioException) {
            return List.of();
        }
    }
}
