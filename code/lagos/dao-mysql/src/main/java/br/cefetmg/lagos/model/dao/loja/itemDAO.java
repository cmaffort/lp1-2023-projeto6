package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.Item;

import java.util.List;

public class itemDAO extends AbstractDAO implements IItemDAO {
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
    public Long inserir(Item item) throws PersistenceException {
        return null;
    }

    @Override
    public boolean alterar(Item item) throws PersistenceException {
        return false;
    }

    @Override
    public boolean remover(Item item) throws PersistenceException {
        return false;
    }

    @Override
    public List<Item> listar() throws PersistenceException {
        return null;
    }

    @Override
    public List<Item> listar(DTO... related) throws PersistenceException {
        return null;
    }

    @Override
    public Item consultarPorId(Long id) throws PersistenceException {
        return null;
    }
}
