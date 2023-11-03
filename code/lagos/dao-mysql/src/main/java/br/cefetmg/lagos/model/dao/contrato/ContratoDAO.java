package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.*;
import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dto.contrato.Contrato;

import java.util.List;
import java.util.Map;

public class ContratoDAO extends AbstractDAO<Contrato> implements IContratoDAO {
    private static final IPeriodicidadeDAO PERIODICIDADE_DAO;

    static {
        PERIODICIDADE_DAO = new PeriodicidadeDAO();
    }

    @Override
    protected Contrato getDTO() {
        return new Contrato();
    }

    @Override
    protected Map<String, IDAO> getDAOs() {
        return Map.ofEntries(
                Map.entry("periodicidade", PERIODICIDADE_DAO)
        );
    }

    @Override
    protected List<String> getOrderByPriority() {
        return List.of("data_de_criacao");
    }
}
