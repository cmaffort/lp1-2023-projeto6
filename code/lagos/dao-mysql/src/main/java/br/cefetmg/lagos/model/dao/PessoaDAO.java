package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.DTO;
import br.cefetmg.lagos.model.dto.Pessoa;

import java.util.Arrays;
import java.util.List;

public class PessoaDAO extends DAO implements IPessoaDAO {
    protected Class<? extends DTO> getDTOClass() {
        return Pessoa.class;
    }

    protected String getTable() {
        return "pessoa";
    }

    protected List<List<String>> getColumnsPreparedStatementInserir() {
        return Arrays.asList(
                Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone")
        );
    }

    @Override
    public Long inserir(Pessoa pessoa) throws PersistenceException {
        return super.inserir(pessoa);
    }

    protected List<List<String>> getColumnsPreparedStatementAlterar() {
        return Arrays.asList(
                Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone"),
                List.of("pk")
        );
    }

    @Override
    public boolean alterar(Pessoa pessoa) throws PersistenceException {
        return super.alterar(pessoa);
    }

    protected List<List<String>> getColumnsPreparedStatementRemover() {
        return Arrays.asList(
                List.of("pk")
        );
    }

    @Override
    public boolean remover(Pessoa pessoa) throws PersistenceException {
        return super.remover(pessoa);
    }

    protected List<List<String>> getColumnsResultSetListar() {
        return Arrays.asList(
                Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone", "pk")
        );
    }

    protected List<String> getOrderByPriority() {
        return Arrays.asList("nome", "sobrenome");
    }

    @Override
    public List<Pessoa> listar() throws PersistenceException {
        return (List<Pessoa>) super.listar();
    }

    protected List<List<String>> getColumnsPreparedStatementConsultar() {
        return Arrays.asList(
                List.of("pk")
        );
    }

    protected List<List<String>> getColumnsResultSetConsultar() {
        return Arrays.asList(
                Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone", "pk")
        );
    }

    @Override
    public Pessoa cosultarPorId(Long id) throws PersistenceException {
        return (Pessoa) super.cosultarPorId(id);
    }
}
