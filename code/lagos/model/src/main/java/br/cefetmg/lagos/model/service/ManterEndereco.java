package br.cefetmg.lagos.model.service;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.base.AbstractManter;
import br.cefetmg.lagos.model.dao.EnderecoDAO;
import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dto.Endereco;

public class ManterEndereco extends AbstractManter<Endereco> implements IManterEndereco {
    @Override
    protected IDAO<Endereco> getDAO() {
        return new EnderecoDAO();
    }

    @Override
    protected Endereco getDTOInstance() {
        return new Endereco();
    }

    protected boolean isCepValid(Integer cep) {
        return cep.toString().length() == 8;
    }

    protected void assertCepIsValid(Integer cep) throws NegocioException {
        if (!isCepValid(cep))
            throw new NegocioException("O CEP deve conter exatamente 8 digitos.");
    }

    @Override
    public Long cadastrar(Endereco endereco) throws NegocioException, PersistenceException {
        assertCepIsValid(endereco.getCep());
        return super.cadastrar(endereco);
    }

    @Override
    public boolean alterar(Endereco endereco) throws NegocioException, PersistenceException {
        assertCepIsValid(endereco.getCep());
        return super.alterar(endereco);
    }
}
