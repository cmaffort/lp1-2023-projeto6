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
    public Long inserir(Endereco endereco) throws PersistenceException {
        return super.inserir(endereco);
    }

    @Override
    public boolean alterar(Endereco endereco) throws PersistenceException {
        return super.alterar(endereco);
    }

    @Override
    public boolean remover(Endereco endereco) throws PersistenceException {
        return super.remover(endereco);
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
    public Endereco consultarPorId(Long id) throws PersistenceException {
        return (Endereco) super.consultarPorId(id);
    }
}
