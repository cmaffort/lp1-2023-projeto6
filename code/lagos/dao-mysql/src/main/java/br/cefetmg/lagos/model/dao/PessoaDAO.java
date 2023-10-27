package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.connections.ConnectionManager;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.util.StringSql;
import br.cefetmg.lagos.model.dto.DTO;
import br.cefetmg.lagos.model.dto.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PessoaDAO extends DAO implements IPessoaDAO {
    @Override
    protected String getTable() {
        return "pessoa";
    }

    @Override
    protected Class<? extends DTO> getDTO() {
        return Pessoa.class;
    }

    @Override
    protected List<String> getColumnsInsert() {
        return Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone");
    }

    @Override
    public Long inserir(Pessoa pessoa) throws PersistenceException {
        Long id = super.inserir(pessoa);
        if (id != null)
            pessoa.setId(id);
        return id;
    }

    protected List<String> getColumnsUpdateSet() {
        return Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone");
    }

    protected List<String> getColumnsWhere() {
        return List.of("pk");
    }

    @Override
    public boolean alterar(Pessoa pessoa) throws PersistenceException {
        return super.alterar(pessoa);
    }

    @Override
    public boolean remover(Pessoa pessoa) throws PersistenceException {
        return super.remover(pessoa);
    }

    @Override
    protected List<String> getColumnsOrderBy() {
        return Arrays.asList("nome", "sobrenome");
    }

    @Override
    protected List<String> getColumnsSelect() {
        return Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone", "pk");
    }

    @Override
    public List<Pessoa> listar() throws PersistenceException {
        return (List<Pessoa>) super.listar();
    }

    @Override
    public Pessoa cosultarPorId(Long id) throws PersistenceException {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        return (Pessoa) super.cosultarPorId(id, pessoa);
    }

    public static void main(String[] args) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pessoa = new Pessoa();
        //values ('José', 'Judeu', '2006-07-15', 'eduardbh2014@gmail.com', 32999781209);
        pessoa.setNome("José");
        pessoa.setSobrenome("Judeu");
        pessoa.setNascimento(Date.valueOf("2006-07-15"));
        pessoa.setEmail("eduardbh2014@gmail.com");
        pessoa.setTelefone(32999781209L);
        try {
            System.out.println(pessoaDAO.listar().size());
            System.out.println(pessoaDAO.cosultarPorId(4L).getSobrenome());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
