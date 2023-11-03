package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.Endereco;

import java.util.List;

public class EnderecoDAO extends AbstractDAO<Endereco> implements IEnderecoDAO {
    @Override
    protected Endereco getDTO() {
        return new Endereco();
    }
}
