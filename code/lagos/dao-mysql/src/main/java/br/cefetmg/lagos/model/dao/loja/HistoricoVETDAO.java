package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.HistoricoVET;

import java.util.List;

public class HistoricoVETDAO extends AbstractDAO implements IHistoricoVETDAO {
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
    public boolean inserir(HistoricoVET historicoVET) throws PersistenceException {
        return false;
    }

    @Override
    public boolean alterar(HistoricoVET historicoVET) throws PersistenceException {
        return false;
    }

    @Override
    public boolean remover(HistoricoVET historicoVET) throws PersistenceException {
        return false;
    }

    @Override
    public List<HistoricoVET> listar() throws PersistenceException {
        return null;
    }

    @Override
    public HistoricoVET consultarPorId(Long id) throws PersistenceException {
        return null;
    }
}
