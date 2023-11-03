package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dto.loja.Promocao;

public class PromocaoDAO extends AbstractDAO<Promocao> implements IPromocaoDAO {
    @Override
    protected Promocao getDTO() {
        return new Promocao();
    }
}
