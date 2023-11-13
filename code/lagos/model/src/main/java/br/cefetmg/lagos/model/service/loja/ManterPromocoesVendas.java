package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.loja.IPromocoesVendasDAO;
import br.cefetmg.lagos.model.dao.loja.PromocoesVendasDAO;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.loja.Produto;
import br.cefetmg.lagos.model.dto.loja.PromocoesProdutos;
import br.cefetmg.lagos.model.dto.loja.PromocoesVendas;
import br.cefetmg.lagos.model.dto.loja.Venda;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;

import java.util.List;

public class ManterPromocoesVendas extends AbstractManterLojaModule<PromocoesVendas> implements IManterPromocoesVendas {
    @Override
    protected IPromocoesVendasDAO getDAO() {
        return new PromocoesVendasDAO();
    }

    @Override
    protected PromocoesVendas getDTOInstance() {
        return new PromocoesVendas();
    }

    @Override
    protected List<PromocoesVendas> pesquisarPorLojaNotRelated(Loja loja) throws PersistenceException, NegocioException {
        try {
            return pesquisarPorQualquerDosRelacionados((new ManterVenda()).pesquisarPorLoja(loja).toArray(new Venda[0]));
        } catch (NegocioException negocioException) {
            return List.of();
        }
    }
}
