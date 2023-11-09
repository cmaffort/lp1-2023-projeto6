package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.loja.IPromocaoDAO;
import br.cefetmg.lagos.model.dao.loja.PromocaoDAO;
import br.cefetmg.lagos.model.dto.loja.Promocao;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;

public class ManterPromocao extends AbstractManterLojaModule<Promocao> implements IManterPromocao {
    @Override
    protected IPromocaoDAO getDAO() {
        return new PromocaoDAO();
    }

    @Override
    protected Promocao getDTOInstance() {
        return new Promocao();
    }
}
