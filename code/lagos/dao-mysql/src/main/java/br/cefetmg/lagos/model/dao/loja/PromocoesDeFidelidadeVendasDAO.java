package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.PromocoesDeFidelidadeVendas;

import java.util.List;

public class PromocoesDeFidelidadeVendasDAO extends AbstractDAO<PromocoesDeFidelidadeVendas> implements IPromocoesDeFidelidadeVendasDAO {
    @Override
    protected PromocoesDeFidelidadeVendas getDTO() {
        return new PromocoesDeFidelidadeVendas();
    }
}
