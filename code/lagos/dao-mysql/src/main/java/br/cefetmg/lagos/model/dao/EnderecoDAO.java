package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dto.Endereco;

public class EnderecoDAO extends AbstractDAO<Endereco> implements IEnderecoDAO {
    @Override
    protected Endereco getDTO() {
        return new Endereco();
    }
}
