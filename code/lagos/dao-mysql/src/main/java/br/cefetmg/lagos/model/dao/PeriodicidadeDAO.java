package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dto.Periodicidade;

public class PeriodicidadeDAO extends AbstractDAO<Periodicidade> implements IPeriodicidadeDAO {
    @Override
    protected Periodicidade getDTO() {
        return new Periodicidade();
    }
}
