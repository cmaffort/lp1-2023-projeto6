package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.loja.IFuncionarioDAO;
import br.cefetmg.lagos.model.dao.loja.FuncionarioDAO;
import br.cefetmg.lagos.model.dto.loja.Funcionario;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;

public class ManterFuncionario extends AbstractManterLojaModule<Funcionario> implements IManterFuncionario {
    @Override
    protected IFuncionarioDAO getDAO() {
        return new FuncionarioDAO();
    }

    @Override
    protected Funcionario getDTOInstance() {
        return new Funcionario();
    }
}
