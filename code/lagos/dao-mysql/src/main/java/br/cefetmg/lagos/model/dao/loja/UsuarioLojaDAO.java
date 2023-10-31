package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;

import java.util.List;

public class UsuarioLojaDAO extends AbstractDAO implements IUsuarioLojaDAO {
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
    public Long inserir(UsuarioLoja usuarioLoja) throws PersistenceException {
        return null;
    }

    @Override
    public boolean alterar(UsuarioLoja usuarioLoja) throws PersistenceException {
        return false;
    }

    @Override
    public boolean remover(UsuarioLoja usuarioLoja) throws PersistenceException {
        return false;
    }

    @Override
    public List<UsuarioLoja> listar() throws PersistenceException {
        return null;
    }

    @Override
    public UsuarioLoja consultarPorId(Long id) throws PersistenceException {
        return null;
    }
}
