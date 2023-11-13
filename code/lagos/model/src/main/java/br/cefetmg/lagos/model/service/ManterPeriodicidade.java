package br.cefetmg.lagos.model.service;

import br.cefetmg.lagos.model.service.base.AbstractManter;
import br.cefetmg.lagos.model.dao.IPeriodicidadeDAO;
import br.cefetmg.lagos.model.dao.PeriodicidadeDAO;
import br.cefetmg.lagos.model.dto.Periodicidade;

public class ManterPeriodicidade extends AbstractManter<Periodicidade> implements IManterPeriodicidade {
    @Override
    protected IPeriodicidadeDAO getDAO() {
        return new PeriodicidadeDAO();
    }

    @Override
    protected Periodicidade getDTOInstance() {
        return new Periodicidade();
    }
}
