package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.Estoquista;

import java.util.List;

public class EstoquistaDAO extends AbstractDAO implements IEstoquistaDAO {
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
    public Long inserir(Estoquista etoquista) throws PersistenceException {
        return null;
    }

    @Override
    public boolean alterar(Estoquista estoquista) throws PersistenceException {
        return false;
    }

    @Override
    public boolean remover(Estoquista estoquista) throws PersistenceException {
        return false;
    }

    @Override
    public List<Estoquista> listar() throws PersistenceException {
        return null;
    }

    @Override
    public Estoquista cosultarPorId(Long id) throws PersistenceException {
        return null;
    }
}
