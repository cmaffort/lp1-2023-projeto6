package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.Chefe;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.List;

public class ChefeDAO extends AbstractDAO implements IChefeDAO {
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
    public Long inserir(Chefe chefe) throws PersistenceException {
        return null;
    }

    @Override
    public boolean alterar(Chefe chefe) throws PersistenceException {
        return false;
    }

    @Override
    public boolean remover(Chefe chefe) throws PersistenceException {
        return false;
    }

    @Override
    public List<Chefe> listar() throws PersistenceException {
        return null;
    }

    @Override
    public Chefe cosultarPorId(Long id) throws PersistenceException {
        return null;
    }
}
