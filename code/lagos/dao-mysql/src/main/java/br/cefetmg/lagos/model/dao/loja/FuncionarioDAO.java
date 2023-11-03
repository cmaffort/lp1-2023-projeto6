package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dto.loja.Funcionario;

public class FuncionarioDAO extends AbstractDAO<Funcionario> implements IFuncionarioDAO {
    @Override
    protected Funcionario getDTO() {
        return new Funcionario();
    }
}
