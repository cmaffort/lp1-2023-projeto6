package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dto.loja.PromocoesDeFidelidadeVendas;

public class PromocoesDeFidelidadeVendasDAO extends AbstractDAO<PromocoesDeFidelidadeVendas> implements IPromocoesDeFidelidadeVendasDAO {
    @Override
    protected PromocoesDeFidelidadeVendas getDTO() {
        return new PromocoesDeFidelidadeVendas();
    }
}
