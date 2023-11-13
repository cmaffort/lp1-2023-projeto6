package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.loja.IFluxoDeCaixaDAO;
import br.cefetmg.lagos.model.dao.loja.FluxoDeCaixaDAO;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.loja.Caixa;
import br.cefetmg.lagos.model.dto.loja.FluxoDeCaixa;
import br.cefetmg.lagos.model.dto.loja.Produto;
import br.cefetmg.lagos.model.dto.loja.PromocoesProdutos;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;

import java.util.List;

public class ManterFluxoDeCaixa extends AbstractManterLojaModule<FluxoDeCaixa> implements IManterFluxoDeCaixa {
    @Override
    protected IFluxoDeCaixaDAO getDAO() {
        return new FluxoDeCaixaDAO();
    }

    @Override
    protected FluxoDeCaixa getDTOInstance() {
        return new FluxoDeCaixa();
    }

    @Override
    protected List<FluxoDeCaixa> pesquisarPorLojaNotRelated(Loja loja) throws PersistenceException, NegocioException {
        try {
            return pesquisarPorQualquerDosRelacionados((new ManterCaixa()).pesquisarPorLoja(loja).toArray(new Caixa[0]));
        } catch (NegocioException negocioException) {
            return List.of();
        }
    }
}
