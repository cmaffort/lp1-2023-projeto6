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
    protected List<List<String>> getColumnsPreparedStatementInserir() {
        return Arrays.asList(
                Arrays.asList("periodo", "quantidade_dias_por_periodo")
        );
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementAlterar() {
        return Arrays.asList(
                Arrays.asList("periodo", "quantidade_dias_por_periodo"),
                List.of("pk")
        );
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementRemover() {
        return Arrays.asList(
                List.of("pk")
        );
    }

    @Override
    protected List<List<String>> getColumnsResultSetListar() {
        return Arrays.asList(
                Arrays.asList("periodo", "quantidade_dias_por_periodo", "pk")
        );
    }

    @Override
    protected List<String> getOrderByPriority() {
        return Arrays.asList("pk");
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementConsultar() {
        return Arrays.asList(
                List.of("pk")
        );
    }

    @Override
    protected List<List<String>> getColumnsResultSetConsultar() {
        return Arrays.asList(
                Arrays.asList("periodo", "quantidade_dias_por_periodo", "pk")
        );
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
    public Periodicidade cosultarPorId(Long id) throws PersistenceException {
        return (Periodicidade) super.cosultarPorId(id);
    }
}
