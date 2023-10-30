package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.Compra;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.List;

public class CompraDAO extends AbstractDAO implements ICompraDAO {
    @Override
    protected DTO getDTO() {
        return null;
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementInserir() {
        return null;
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementAlterar() {
        return null;
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
    public Long inserir(Compra compra) throws PersistenceException {
        return null;
    }

    @Override
    public boolean alterar(Compra compra) throws PersistenceException {
        return false;
    }

    @Override
    public boolean remover(Compra compra) throws PersistenceException {
        return false;
    }

    @Override
    public List<Compra> listar() throws PersistenceException {
        return null;
    }

    @Override
    public Compra cosultarPorId(Long id) throws PersistenceException {
        return null;
    }
}
