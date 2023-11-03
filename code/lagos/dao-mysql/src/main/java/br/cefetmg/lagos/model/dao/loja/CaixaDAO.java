package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Cartao;
import br.cefetmg.lagos.model.dto.loja.Caixa;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.List;

public class CaixaDAO extends AbstractDAO<Caixa> implements ICaixaDAO {
    @Override
    protected Caixa getDTO() {
        return new Caixa();
    }
}
