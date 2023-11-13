package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.loja.IPromocoesDeFidelidadeVendasDAO;
import br.cefetmg.lagos.model.dao.loja.PromocoesDeFidelidadeVendasDAO;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.loja.Produto;
import br.cefetmg.lagos.model.dto.loja.PromocoesDeFidelidadeVendas;
import br.cefetmg.lagos.model.dto.loja.PromocoesProdutos;
import br.cefetmg.lagos.model.dto.loja.Venda;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;

import java.util.List;

public class ManterPromocoesDeFidelidadeVendas extends AbstractManterLojaModule<PromocoesDeFidelidadeVendas> implements IManterPromocoesDeFidelidadeVendas {
    @Override
    protected IPromocoesDeFidelidadeVendasDAO getDAO() {
        return new PromocoesDeFidelidadeVendasDAO();
    }

    @Override
    protected PromocoesDeFidelidadeVendas getDTOInstance() {
        return new PromocoesDeFidelidadeVendas();
    }

    @Override
    protected List<PromocoesDeFidelidadeVendas> pesquisarPorLojaNotRelated(Loja loja) throws PersistenceException, NegocioException {
        try {
            return pesquisarPorQualquerDosRelacionados((new ManterVenda()).pesquisarPorLoja(loja).toArray(new Venda[0]));
        } catch (NegocioException negocioException) {
            return List.of();
        }
    }
}
