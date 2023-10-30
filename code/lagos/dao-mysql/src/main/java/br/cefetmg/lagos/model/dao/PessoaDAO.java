package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.Pessoa;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class PessoaDAO extends AbstractDAO implements IPessoaDAO {
    @Override
    protected DTO getDTO() {
        return new Pessoa();
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementInserir() {
        return Arrays.asList(
                Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone")
        );
    }

    @Override
    public Long inserir(Pessoa pessoa) throws PersistenceException {
        return super.inserir(pessoa);
    }

    @Override
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

    @Override
    protected List<List<String>> getColumnsPreparedStatementRemover() {
        return Arrays.asList(
                List.of("pk")
        );
    }

    @Override
    public boolean remover(Pessoa pessoa) throws PersistenceException {
        return super.remover(pessoa);
    }

    @Override
    protected List<List<String>> getColumnsResultSetListar() {
        return Arrays.asList(
                Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone", "pk")
        );
    }

    @Override
    protected List<String> getOrderByPriority() {
        return Arrays.asList("nome", "sobrenome");
    }

    @Override
    public List<Pessoa> listar() throws PersistenceException {
        return (List<Pessoa>) super.listar();
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
                Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone", "pk")
        );
    }

    @Override
    public Pessoa cosultarPorId(Long id) throws PersistenceException {
        return (Pessoa) super.cosultarPorId(id);
    }

    public static void main(String[] args) throws PersistenceException {
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("testesssss");
        pessoa.setSobrenome("de paula");
        pessoa.setEmail("pessao@f.con");
        pessoa.setNascimento(Date.valueOf("2008-09-23"));
        pessoa.setTelefone(2123455L);

        for (Pessoa p : pessoaDAO.listar())
            System.out.println(p);
    }
}
