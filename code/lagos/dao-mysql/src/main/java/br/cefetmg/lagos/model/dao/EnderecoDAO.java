package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.Endereco;

import java.util.Arrays;
import java.util.List;

public class EnderecoDAO extends AbstractDAO implements IEnderecoDAO {
    @Override
    protected DTO getDTO() {
        return new Endereco();
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementInserir() {
        return Arrays.asList(
                Arrays.asList("cep", "numero")
        );
    }

    @Override
    public Long inserir(Endereco endereco) throws PersistenceException {
        return super.inserir(endereco);
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementAlterar() {
        return Arrays.asList(
                Arrays.asList("cep", "numero"),
                List.of("pk")
        );
    }

    @Override
    public boolean alterar(Endereco endereco) throws PersistenceException {
        return super.alterar(endereco);
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementRemover() {
        return Arrays.asList(
                List.of("pk")
        );
    }

    @Override
    public boolean remover(Endereco endereco) throws PersistenceException {
        return super.remover(endereco);
    }

    @Override
    protected List<List<String>> getColumnsResultSetListar() {
        return Arrays.asList(
                Arrays.asList("cep", "numero", "pk")
        );
    }

    @Override
    protected List<String> getOrderByPriority() {
        return Arrays.asList("pk");
    }

    @Override
    public List<Endereco> listar() throws PersistenceException {
        return (List<Endereco>) super.listar();
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
                Arrays.asList("cep", "numero", "pk")
        );
    }

    @Override
    public Endereco cosultarPorId(Long id) throws PersistenceException {
        return (Endereco) super.cosultarPorId(id);
    }
}
