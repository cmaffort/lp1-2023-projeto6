package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.Pessoa;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class PessoaDAO extends AbstractDAO<Pessoa> implements IPessoaDAO {
    @Override
    protected Pessoa getDTO() {
        return new Pessoa();
    }

    @Override
    protected List<String> getOrderByPriority() {
        return Arrays.asList("nome", "sobrenome");
    }
}
