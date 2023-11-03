package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.Item;

import java.util.List;

public class ItemDAO extends AbstractDAO<Item> implements IItemDAO {
    @Override
    protected Item getDTO() {
        return new Item();
    }
}
