package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.FluxoDeCaixa;

import java.util.List;

public class FluxoDeCaixaDAO extends AbstractDAO<FluxoDeCaixa> implements IFluxoDeCaixaDAO {
    @Override
    protected FluxoDeCaixa getDTO() {
        return new FluxoDeCaixa();
    }
}
