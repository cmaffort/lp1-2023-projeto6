package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.loja.ICaixaDAO;
import br.cefetmg.lagos.model.dao.loja.CaixaDAO;
import br.cefetmg.lagos.model.dto.loja.Caixa;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;

public class ManterCaixa extends AbstractManterLojaModule<Caixa> implements IManterCaixa {
    @Override
    protected ICaixaDAO getDAO() {
        return new CaixaDAO();
    }

    @Override
    protected Caixa getDTOInstance() {
        return new Caixa();
    }
}
