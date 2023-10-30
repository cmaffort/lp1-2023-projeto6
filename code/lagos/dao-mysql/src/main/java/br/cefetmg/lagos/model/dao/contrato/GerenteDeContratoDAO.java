package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.GerenteDeContrato;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.List;

public class GerenteDeContratoDAO extends AbstractDAO implements IGerenteDeContratoDAO {
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
    public Long inserir(GerenteDeContrato gerenteDeContrato) throws PersistenceException {
        return null;
    }

    @Override
    public boolean alterar(GerenteDeContrato gerenteDeContrato) throws PersistenceException {
        return false;
    }

    @Override
    public boolean remover(GerenteDeContrato gerenteDeContrato) throws PersistenceException {
        return false;
    }

    @Override
    public List<GerenteDeContrato> listar() throws PersistenceException {
        return null;
    }

    @Override
    public GerenteDeContrato cosultarPorId(Long id) throws PersistenceException {
        return null;
    }
}
