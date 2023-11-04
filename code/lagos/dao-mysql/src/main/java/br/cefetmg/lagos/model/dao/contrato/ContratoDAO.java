package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.*;
import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.contrato.Usuario;

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

    @Override
    public List<Contrato> filtrarRelated(Usuario usuario) throws PersistenceException {
        return selectFromManyToMany(new ContratoAssinado(), usuario);
    }
}
