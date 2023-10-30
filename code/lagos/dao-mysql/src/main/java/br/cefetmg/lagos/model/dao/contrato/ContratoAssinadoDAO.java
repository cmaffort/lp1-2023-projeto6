package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Contratante;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.Arrays;
import java.util.List;

public class ContratoAssinadoDAO extends AbstractDAO implements IContratoAssinadoDAO {
    private static final IContratanteDAO CONTRATANTE_DAO;
    private static final IContratoDAO CONTRATO_DAO;

    static {
        CONTRATANTE_DAO = new ContratanteDAO();
        CONTRATO_DAO = new ContratoDAO();
    }

    private static IContratanteDAO getContratanteDao() {
        return CONTRATANTE_DAO;
    }

    private static IContratoDAO getContratoDao() {
        return CONTRATO_DAO;
    }

    @Override
    protected DTO getDTO() {
        return new ContratoAssinado();
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementInserir() {
        return Arrays.asList(
                Arrays.asList("vigente", "data_de_contratacao", "cancelado", "usuario__fk", "contrato__fk")
        );
    }

    @Override
    public Long inserir(ContratoAssinado contratoAssinado) throws PersistenceException {
        return super.inserir(contratoAssinado);
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementAlterar() {
        return Arrays.asList(
                Arrays.asList("vigente", "data_de_contratacao", "cancelado", "usuario__fk", "contrato__fk")
        );
    }

    @Override
    public boolean alterar(ContratoAssinado contratoAssinado) throws PersistenceException {
        return super.alterar(contratoAssinado);
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementRemover() {
        return Arrays.asList(
                List.of("pk")
        );
    }

    @Override
    public boolean remover(ContratoAssinado contratoAssinado) throws PersistenceException {
        return super.remover(contratoAssinado);
    }

    @Override
    protected List<List<String>> getColumnsResultSetListar() {
        return Arrays.asList(
                Arrays.asList("vigente", "data_de_contratacao", "cancelado", "usuario__fk", "contrato__fk", "pk")
        );
    }

    @Override
    protected List<String> getOrderByPriority() {
        return List.of("data_de_contratacao");
    }

    private ContratoAssinado fillRelatedDTOs(ContratoAssinado contratoAssinado) throws PersistenceException {
        IContratanteDAO contratanteDAO = getContratanteDao();
        IContratoDAO contratoDAO = getContratoDao();

        Contratante contratante = contratanteDAO.cosultarPorId(contratoAssinado.getContratanteAsLong());
        Contrato contrato = contratoDAO.cosultarPorId(contratoAssinado.getContratoAsLong());

        contratoAssinado.setContratante(contratante);
        contratoAssinado.setContrato(contrato);

        return contratoAssinado;
    }

    private List<ContratoAssinado> fillRelatedDTOs(List<ContratoAssinado> contratosAssinados) throws PersistenceException {
        for (ContratoAssinado contratoAssinado : contratosAssinados)
            fillRelatedDTOs(contratoAssinado);
        return contratosAssinados;
    }

    @Override
    public List<ContratoAssinado> listar() throws PersistenceException {
        return fillRelatedDTOs((List<ContratoAssinado>) super.listar());
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
                Arrays.asList("vigente", "data_de_contratacao", "cancelado", "usuario__fk", "contrato__fk", "pk")
        );
    }

    @Override
    public ContratoAssinado cosultarPorId(Long id) throws PersistenceException {
        return fillRelatedDTOs((ContratoAssinado) super.cosultarPorId(id));
    }

    @Override
    public List<ContratoAssinado> listar(DTO dto) throws PersistenceException {
        return (List<ContratoAssinado>) super.listar(dto);
    }
}
