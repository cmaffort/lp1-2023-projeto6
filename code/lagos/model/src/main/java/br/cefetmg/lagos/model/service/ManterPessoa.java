package br.cefetmg.lagos.model.service;

import br.cefetmg.lagos.model.base.AbstractManter;
import br.cefetmg.lagos.model.dao.IPessoaDAO;
import br.cefetmg.lagos.model.dao.PessoaDAO;
import br.cefetmg.lagos.model.dto.Pessoa;

public class ManterPessoa extends AbstractManter<Pessoa> implements IManterPessoa {
    @Override
    protected IPessoaDAO getDAO() {
        return new PessoaDAO();
    }

    @Override
    protected Pessoa getDTOInstance() {
        return new Pessoa();
    }
}
