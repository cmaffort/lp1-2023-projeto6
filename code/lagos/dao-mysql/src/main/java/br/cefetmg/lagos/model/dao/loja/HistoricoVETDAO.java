package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.HistoricoVET;

import java.util.List;

public class HistoricoVETDAO extends AbstractDAO<HistoricoVET> implements IHistoricoVETDAO {
    @Override
    protected HistoricoVET getDTO() {
        return new HistoricoVET();
    }
}
