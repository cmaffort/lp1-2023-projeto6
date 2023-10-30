package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Periodicidade;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.List;

public class PeriodicidadeDAO extends AbstractDAO implements IPeriodicidadeDAO {
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
    public Long inserir(Periodicidade periodicidade) throws PersistenceException {
        return null;
    }

    @Override
    public boolean alterar(Periodicidade periodicidade) throws PersistenceException {
        return false;
    }

    @Override
    public boolean remover(Periodicidade periodicidade) throws PersistenceException {
        return false;
    }

    @Override
    public List<Periodicidade> listar() throws PersistenceException {
        return null;
    }

    @Override
    public Periodicidade cosultarPorId(Long id) throws PersistenceException {
        return null;
    }
}
