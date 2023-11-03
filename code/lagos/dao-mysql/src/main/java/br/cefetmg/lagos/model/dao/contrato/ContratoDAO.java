package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.*;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Periodicidade;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.dto.base.DTO;

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
