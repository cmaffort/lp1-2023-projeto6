package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dto.loja.HistoricoVET;

public class HistoricoVETDAO extends AbstractDAO<HistoricoVET> implements IHistoricoVETDAO {
    @Override
    protected HistoricoVET getDTO() {
        return new HistoricoVET();
    }
}
