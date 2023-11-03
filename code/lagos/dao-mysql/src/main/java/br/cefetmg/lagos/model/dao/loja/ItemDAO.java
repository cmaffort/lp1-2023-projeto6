package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dto.loja.Item;

public class ItemDAO extends AbstractDAO<Item> implements IItemDAO {
    @Override
    protected Item getDTO() {
        return new Item();
    }
}
