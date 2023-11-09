package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.loja.IHistoricoVETDAO;
import br.cefetmg.lagos.model.dao.loja.HistoricoVETDAO;
import br.cefetmg.lagos.model.dto.loja.HistoricoVET;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;

public class ManterHistoricoVET extends AbstractManterLojaModule<HistoricoVET> implements IManterHistoricoVET {
    @Override
    protected IHistoricoVETDAO getDAO() {
        return new HistoricoVETDAO();
    }

    @Override
    protected HistoricoVET getDTOInstance() {
        return new HistoricoVET();
    }
}
