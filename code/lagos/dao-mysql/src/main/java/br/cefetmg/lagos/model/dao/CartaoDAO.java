package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Cartao;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.Arrays;
import java.util.List;

public class CartaoDAO extends AbstractDAO implements ICartaoDAO {
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
        return null;
    }

    @Override
    protected List<List<String>> getColumnsResultSetListar() {
        return null;
    }

    @Override
    protected List<String> getOrderByPriority() {
        return null;
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementConsultar() {
        return null;
    }

    @Override
    protected List<List<String>> getColumnsResultSetConsultar() {
        return null;
    }

    @Override
    public boolean remover(Cartao cartao) throws PersistenceException {
        return false;
    }

    @Override
    public List<Cartao> listar() throws PersistenceException {
        return null;
    }

    @Override
    public Cartao cosultarPorId(Long id) throws PersistenceException {
        return null;
    }
}
