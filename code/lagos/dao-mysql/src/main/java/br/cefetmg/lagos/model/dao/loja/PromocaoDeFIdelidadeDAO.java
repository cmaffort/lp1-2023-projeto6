package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.PromocaoDeFidelidade;

import java.util.List;

public class PromocaoDeFIdelidadeDAO extends AbstractDAO<PromocaoDeFidelidade> implements IPromocaoDeFidelidadeDAO {
    @Override
    protected PromocaoDeFidelidade getDTO() {
        return new PromocaoDeFidelidade();
    }
}
