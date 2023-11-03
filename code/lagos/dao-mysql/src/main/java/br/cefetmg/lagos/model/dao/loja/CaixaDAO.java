package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dto.loja.Caixa;

public class CaixaDAO extends AbstractDAO<Caixa> implements ICaixaDAO {
    @Override
    protected Caixa getDTO() {
        return new Caixa();
    }
}
