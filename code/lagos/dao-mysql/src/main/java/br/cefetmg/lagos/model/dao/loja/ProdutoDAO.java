package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.Produto;

import java.util.List;

public class ProdutoDAO extends AbstractDAO implements IProdutoDAO {
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
    public Long inserir(Produto produto) throws PersistenceException {
        return null;
    }

    @Override
    public boolean alterar(Produto produto) throws PersistenceException {
        return false;
    }

    @Override
    public boolean remover(Produto produto) throws PersistenceException {
        return false;
    }

    @Override
    public List<Produto> listar() throws PersistenceException {
        return null;
    }

    @Override
    public List<Produto> listar(DTO... related) throws PersistenceException {
        return null;
    }

    @Override
    public Produto consultarPorId(Long id) throws PersistenceException {
        return null;
    }
}
