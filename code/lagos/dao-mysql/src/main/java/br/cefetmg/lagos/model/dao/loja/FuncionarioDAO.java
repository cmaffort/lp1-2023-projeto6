package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.Funcionario;

import java.util.List;

public class FuncionarioDAO extends AbstractDAO implements IFuncionarioDAO {
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
    public boolean inserir(Funcionario funcionario) throws PersistenceException {
        return false;
    }

    @Override
    public boolean alterar(Funcionario funcionario) throws PersistenceException {
        return false;
    }

    @Override
    public boolean remover(Funcionario funcionario) throws PersistenceException {
        return false;
    }

    @Override
    public List<Funcionario> listar() throws PersistenceException {
        return null;
    }

    @Override
    public Funcionario cosultarPorId(Long id) throws PersistenceException {
        return null;
    }
}
