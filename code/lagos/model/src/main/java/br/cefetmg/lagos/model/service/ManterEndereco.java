package br.cefetmg.lagos.model.service;

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
}
