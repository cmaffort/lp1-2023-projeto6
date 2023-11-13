package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.loja.IConfiguracoesDeVendaDAO;
import br.cefetmg.lagos.model.dao.loja.ConfiguracoesDeVendaDAO;
import br.cefetmg.lagos.model.dto.loja.ConfiguracoesDeVenda;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;

public class ManterConfiguracoesDeVenda extends AbstractManterLojaModule<ConfiguracoesDeVenda> implements IManterConfiguracoesDeVenda {
    @Override
    protected IConfiguracoesDeVendaDAO getDAO() {
        return new ConfiguracoesDeVendaDAO();
    }

    @Override
    protected ConfiguracoesDeVenda getDTOInstance() {
        return new ConfiguracoesDeVenda();
    }
}
