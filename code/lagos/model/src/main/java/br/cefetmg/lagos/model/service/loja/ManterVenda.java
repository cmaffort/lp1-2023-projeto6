package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.loja.IVendaDAO;
import br.cefetmg.lagos.model.dao.loja.VendaDAO;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.loja.HistoricoVET;
import br.cefetmg.lagos.model.dto.loja.Produto;
import br.cefetmg.lagos.model.dto.loja.PromocoesProdutos;
import br.cefetmg.lagos.model.dto.loja.Venda;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;

import java.util.List;

public class ManterVenda extends AbstractManterLojaModule<Venda> implements IManterVenda {
    @Override
    protected IVendaDAO getDAO() {
        return new VendaDAO();
    }

    @Override
    protected Venda getDTOInstance() {
        return new Venda();
    }

    @Override
    protected List<Venda> pesquisarPorLojaNotRelated(Loja loja) throws PersistenceException, NegocioException {
        try {
            return pesquisarPorQualquerDosRelacionados((new ManterHistoricoVET()).pesquisarPorLoja(loja).toArray(new HistoricoVET[0]));
        } catch (NegocioException negocioException) {
            return List.of();
        }
    }
}
