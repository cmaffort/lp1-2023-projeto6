package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.ProdutoCompra;

import java.util.List;

public class ProdutoCompraDAO extends AbstractDAO<ProdutoCompra> implements IProdutoCompraDAO {
    @Override
    protected ProdutoCompra getDTO() {
        return new ProdutoCompra();
    }
}
