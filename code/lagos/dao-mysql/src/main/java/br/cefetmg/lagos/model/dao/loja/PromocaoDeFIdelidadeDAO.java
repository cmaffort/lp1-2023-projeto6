package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dto.loja.PromocaoDeFidelidade;

public class PromocaoDeFIdelidadeDAO extends AbstractDAO<PromocaoDeFidelidade> implements IPromocaoDeFidelidadeDAO {
    @Override
    protected PromocaoDeFidelidade getDTO() {
        return new PromocaoDeFidelidade();
    }
}
