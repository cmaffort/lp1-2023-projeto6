package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Periodicidade;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.Arrays;
import java.util.List;

public class PeriodicidadeDAO extends AbstractDAO implements IPeriodicidadeDAO {
    @Override
    protected DTO getDTO() {
        return new Periodicidade();
    }

    @Override
    public Long inserir(Periodicidade periodicidade) throws PersistenceException {
        return super.inserir(periodicidade);
    }

    @Override
    public boolean alterar(Periodicidade periodicidade) throws PersistenceException {
        return super.alterar(periodicidade);
    }

    @Override
    public boolean remover(Periodicidade periodicidade) throws PersistenceException {
        return super.remover(periodicidade);
    }

    @Override
    public List<Periodicidade> listar() throws PersistenceException {
        return (List<Periodicidade>) super.listar();
    }

    @Override
    public Periodicidade consultarPorId(Long id) throws PersistenceException {
        return (Periodicidade) super.consultarPorId(id);
    }
}
