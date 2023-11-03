package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.Venda;

import java.util.List;

public class VendaDAO extends AbstractDAO<Venda> implements IVendaDAO {
    @Override
    protected Venda getDTO() {
        return new Venda();
    }

    @Override
    public Double sum() throws PersistenceException {
        return null;
    }

    @Override
    public Double sum(DTO... related) throws PersistenceException {
        return null;
    }
}
