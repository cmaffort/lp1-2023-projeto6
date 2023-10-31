package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.Caixa;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.List;

public class CaixaDAO extends AbstractDAO implements ICaixaDAO {
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
    public Long inserir(Caixa caixa) throws PersistenceException {
        return null;
    }

    @Override
    public boolean alterar(Caixa caixa) throws PersistenceException {
        return false;
    }

    @Override
    public boolean remover(Caixa caixa) throws PersistenceException {
        return false;
    }

    @Override
    public List<Caixa> listar() throws PersistenceException {
        return null;
    }

    @Override
    public Caixa consultarPorId(Long id) throws PersistenceException {
        return null;
    }

    @Override
    public Caixa consultarPor(DTO... related) throws PersistenceException {
        return null;
    }
}
