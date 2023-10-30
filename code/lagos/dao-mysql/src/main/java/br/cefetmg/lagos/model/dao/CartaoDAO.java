package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.contrato.ContratanteDAO;
import br.cefetmg.lagos.model.dao.contrato.IContratanteDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Cartao;
import br.cefetmg.lagos.model.dto.Endereco;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.contrato.Contratante;

import java.util.Arrays;
import java.util.List;

public class CartaoDAO extends AbstractDAO implements ICartaoDAO {
    private static final IContratanteDAO CONTRATANTE_DAO;
    private static final IEnderecoDAO ENDERECO_DAO;

    static {
        CONTRATANTE_DAO = new ContratanteDAO();
        ENDERECO_DAO = new EnderecoDAO();
    }

    private static IContratanteDAO getContratanteDao() {
        return CONTRATANTE_DAO;
    }

    private static IEnderecoDAO getEnderecoDao() {
        return ENDERECO_DAO;
    }

    @Override
    protected DTO getDTO() {
        return new Cartao();
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementInserir() {
        return Arrays.asList(
                Arrays.asList("numero", "bandeira", "endereco__fk", "usuario__fk")
        );
    }

    @Override
    public Long inserir(Cartao cartao) throws PersistenceException {
        return super.inserir(cartao);
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementAlterar() {
        return Arrays.asList(
                Arrays.asList("numero", "bandeira", "endereco__fk", "usuario__fk")
        );
    }

    @Override
    public boolean alterar(Cartao cartao) throws PersistenceException {
        return super.alterar(cartao);
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementRemover() {
        return Arrays.asList(
                List.of("pk")
        );
    }

    @Override
    public boolean remover(Cartao cartao) throws PersistenceException {
        return super.remover(cartao);
    }

    @Override
    protected List<List<String>> getColumnsResultSetListar() {
        return Arrays.asList(
                Arrays.asList("numero", "bandeira", "endereco__fk", "usuario__fk", "pk")
        );
    }

    @Override
    protected List<String> getOrderByPriority() {
        return List.of("pk");
    }

    private Cartao fillRelatedDTOs(Cartao cartao) throws PersistenceException {
        IContratanteDAO contratanteDAO = getContratanteDao();
        IEnderecoDAO enderecoDAO = getEnderecoDao();

        Contratante contratante = contratanteDAO.cosultarPorId(cartao.getContratanteAsLong());
        Endereco endereco = enderecoDAO.cosultarPorId(cartao.getEnderecoAsLong());

        cartao.setContratante(contratante);
        cartao.setEndereco(endereco);

        return cartao;
    }

    private List<Cartao> fillRelatedDTOs(List<Cartao> cartoes) throws PersistenceException {
        for (Cartao cartao : cartoes)
            fillRelatedDTOs(cartao);
        return cartoes;
    }

    @Override
    public List<Cartao> listar() throws PersistenceException {
        return fillRelatedDTOs((List<Cartao>) super.listar());
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
                Arrays.asList("numero", "bandeira", "endereco__fk", "usuario__fk", "pk")
        );
    }

    @Override
    public Cartao cosultarPorId(Long id) throws PersistenceException {
        return fillRelatedDTOs((Cartao) super.cosultarPorId(id));
    }
}
