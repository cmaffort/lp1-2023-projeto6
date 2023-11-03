package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.Produto;

import java.util.List;

public class ProdutoDAO extends AbstractDAO<Produto> implements IProdutoDAO {
    @Override
    protected Produto getDTO() {
        return new Produto();
    }
}
