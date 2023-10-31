package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.*;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Periodicidade;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.Arrays;
import java.util.List;

public class ContratoDAO extends AbstractDAO implements IContratoDAO {
    private static final IPeriodicidadeDAO PERIODICIDADE_DAO;

    static {
        PERIODICIDADE_DAO = new PeriodicidadeDAO();
    }

    private static IPeriodicidadeDAO getPeriodicidadeDao() {
        return PERIODICIDADE_DAO;
    }

    @Override
    protected DTO getDTO() {
        return new Contrato();
    }

    @Override
    public Long inserir(Contrato contrato) throws PersistenceException {
        return super.inserir(contrato);
    }

    @Override
    public boolean alterar(Contrato contrato) throws PersistenceException {
        return super.alterar(contrato);
    }

    @Override
    public boolean remover(Contrato contrato) throws PersistenceException {
        return super.remover(contrato);
    }

    private Contrato fillFKedDTOs(Contrato contrato) throws PersistenceException {
        IPeriodicidadeDAO periodicidadeDAO = getPeriodicidadeDao();
        Periodicidade periodicidade = periodicidadeDAO.consultarPorId(contrato.getPeriodicidadeAsLong());
        contrato.setPeriodicidade(periodicidade);
        return contrato;
    }

    private List<Contrato> fillFKedDTOs(List<Contrato> contratos) throws PersistenceException {
        for (Contrato contrato : contratos)
            fillFKedDTOs(contrato);
        return contratos;
    }

    @Override
    public List<Contrato> listar() throws PersistenceException {
        return fillFKedDTOs((List<Contrato>) super.listar());
    }

    @Override
    protected List<String> getOrderByPriority() {
        return List.of("data_de_criacao");
    }

    @Override
    public Contrato consultarPorId(Long id) throws PersistenceException {
        return fillFKedDTOs((Contrato) super.consultarPorId(id));
    }
}
