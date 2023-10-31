package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.List;

public class ContratoAssinadoDAO extends AbstractDAO implements IContratoAssinadoDAO {
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
    public Long inserir(ContratoAssinado contratoAssinado) throws PersistenceException {
        return null;
    }

    @Override
    public boolean alterar(ContratoAssinado contratoAssinado) throws PersistenceException {
        return false;
    }

    @Override
    public boolean remover(ContratoAssinado contratoAssinado) throws PersistenceException {
        return false;
    }

    @Override
    public List<ContratoAssinado> listar() throws PersistenceException {
        return null;
    }

    @Override
    public ContratoAssinado cosultarPorId(Long id) throws PersistenceException {
        return null;
    }
}
