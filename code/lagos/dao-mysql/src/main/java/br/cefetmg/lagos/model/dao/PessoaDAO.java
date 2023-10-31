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
    public Long inserir(Pessoa pessoa) throws PersistenceException {
        return super.inserir(pessoa);
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
    protected List<String> getOrderByPriority() {
        return Arrays.asList("nome", "sobrenome");
    }

    @Override
    public List<Pessoa> listar() throws PersistenceException {
        return (List<Pessoa>) super.listar();
    }

    @Override
    public Pessoa consultarPorId(Long id) throws PersistenceException {
        return (Pessoa) super.consultarPorId(id);
    }
}
