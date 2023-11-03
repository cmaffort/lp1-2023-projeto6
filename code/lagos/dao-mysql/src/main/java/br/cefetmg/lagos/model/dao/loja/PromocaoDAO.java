package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.Promocao;

import java.util.List;

public class PromocaoDAO extends AbstractDAO<Promocao> implements IPromocaoDAO {
    @Override
    protected Promocao getDTO() {
        return new Promocao();
    }
}
