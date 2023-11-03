package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dto.loja.FluxoDeCaixa;

public class FluxoDeCaixaDAO extends AbstractDAO<FluxoDeCaixa> implements IFluxoDeCaixaDAO {
    @Override
    protected FluxoDeCaixa getDTO() {
        return new FluxoDeCaixa();
    }
}
