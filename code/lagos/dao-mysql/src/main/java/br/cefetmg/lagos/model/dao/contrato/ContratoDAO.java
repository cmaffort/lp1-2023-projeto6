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
    private static final IContratoAssinadoDAO CONTRATO_ASSINADO_DAO;

    static {
        PERIODICIDADE_DAO = new PeriodicidadeDAO();
        CONTRATO_ASSINADO_DAO = new ContratoAssinadoDAO();
    }

    private static IPeriodicidadeDAO getPeriodicidadeDao() {
        return PERIODICIDADE_DAO;
    }

    private static IContratoAssinadoDAO getContratoAssinadoDao() {
        return CONTRATO_ASSINADO_DAO;
    }

    @Override
    protected DTO getDTO() {
        return new Contrato();
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementInserir() {
        return Arrays.asList(
                Arrays.asList("ativo", "descricao", "preco", "documento", "taxa_de_multa", "numero_de_lojas",
                        "data_de_criacao", "periodicidade__fk")
        );
    }

    @Override
    public Long inserir(Contrato contrato) throws PersistenceException {
        return super.inserir(contrato);
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementAlterar() {
        return Arrays.asList(
                Arrays.asList("ativo", "descricao", "preco", "documento", "taxa_de_multa", "numero_de_lojas",
                        "data_de_criacao", "periodicidade__fk")
        );
    }

    @Override
    public boolean alterar(Contrato contrato) throws PersistenceException {
        return super.alterar(contrato);
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementRemover() {
        return Arrays.asList(
                List.of("pk")
        );
    }

    @Override
    public boolean remover(Contrato contrato) throws PersistenceException {
        return super.remover(contrato);
    }

    private Contrato fillRelatedDTOs(Contrato contrato) throws PersistenceException {
        IPeriodicidadeDAO periodicidadeDAO = getPeriodicidadeDao();
        Periodicidade periodicidade = periodicidadeDAO.cosultarPorId(contrato.getPeriodicidadeAsLong());
        contrato.setPeriodicidade(periodicidade);
        return contrato;
    }

    private List<Contrato> fillRelatedDTOs(List<Contrato> contratos) throws PersistenceException {
        for (Contrato contrato : contratos)
            fillRelatedDTOs(contrato);
        return contratos;
    }

    private Contrato setRelatedFields(Contrato contrato) throws PersistenceException {
        IContratoAssinadoDAO contratoAssinadoDAO = getContratoAssinadoDao();
        contrato.setContratosAssinados(contratoAssinadoDAO.listar(contrato));
        return contrato;
    }

    private List<Contrato> setRelatedFields(List<Contrato> contratos) throws PersistenceException {
        for (Contrato contrato : contratos)
            setRelatedFields(contrato);
        return contratos;
    }

    @Override
    public List<Contrato> listar() throws PersistenceException {
        return setRelatedFields(fillRelatedDTOs((List<Contrato>) super.listar()));
    }

    @Override
    protected List<List<String>> getColumnsResultSetListar() {
        return Arrays.asList(
                Arrays.asList("ativo", "descricao", "preco", "documento", "taxa_de_multa", "numero_de_lojas",
                        "data_de_criacao", "periodicidade__fk", "pk")
        );
    }

    @Override
    protected List<String> getOrderByPriority() {
        return List.of("data_de_criacao");
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementConsultar() {
        return Arrays.asList(
                List.of("pk")
        );
    }

    @Override
    protected List<List<String>> getColumnsResultSetConsultar() {
        return Arrays.asList(
                Arrays.asList("ativo", "descricao", "preco", "documento", "taxa_de_multa", "numero_de_lojas",
                        "data_de_criacao", "periodicidade__fk", "pk")
        );
    }

    @Override
    public Contrato cosultarPorId(Long id) throws PersistenceException {
        return setRelatedFields(fillRelatedDTOs((Contrato) super.cosultarPorId(id)));
    }
}
