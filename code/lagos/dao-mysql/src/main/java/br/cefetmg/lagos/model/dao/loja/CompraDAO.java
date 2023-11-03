package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.Compra;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.List;

public class CompraDAO extends AbstractDAO<Compra> implements ICompraDAO {
    @Override
    protected Compra getDTO() {
        return new Compra();
    }
}
