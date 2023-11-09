package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.loja.IPromocaoDeFidelidadeDAO;
import br.cefetmg.lagos.model.dao.loja.PromocaoDeFidelidadeDAO;
import br.cefetmg.lagos.model.dto.loja.PromocaoDeFidelidade;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;

public class ManterPromocaoDeFidelidade extends AbstractManterLojaModule<PromocaoDeFidelidade> implements IManterPromocaoDeFidelidade {
    @Override
    protected IPromocaoDeFidelidadeDAO getDAO() {
        return new PromocaoDeFidelidadeDAO();
    }

    @Override
    protected PromocaoDeFidelidade getDTOInstance() {
        return new PromocaoDeFidelidade();
    }
}
