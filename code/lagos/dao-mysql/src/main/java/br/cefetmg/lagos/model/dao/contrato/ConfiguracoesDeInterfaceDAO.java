package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.ConfiguracoesDeInterface;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.List;

public class ConfiguracoesDeInterfaceDAO extends AbstractDAO implements IConfiguracoesDeInterfaceDAO {
    @Override
    protected DTO getDTO() {
        return new ConfiguracoesDeInterface();
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
    public Long inserir(ConfiguracoesDeInterface configuracoesDeInterface) throws PersistenceException {
        return null;
    }

    @Override
    public boolean alterar(ConfiguracoesDeInterface configuracoesDeInterface) throws PersistenceException {
        return false;
    }

    @Override
    public boolean remover(ConfiguracoesDeInterface configuracoesDeInterface) throws PersistenceException {
        return false;
    }

    @Override
    public List<ConfiguracoesDeInterface> listar() throws PersistenceException {
        return null;
    }

    @Override
    public ConfiguracoesDeInterface cosultarPorId(Long id) throws PersistenceException {
        return null;
    }
}
