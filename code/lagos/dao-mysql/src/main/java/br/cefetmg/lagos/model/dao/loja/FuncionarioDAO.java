package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.Funcionario;

import java.util.List;

public class FuncionarioDAO extends AbstractDAO<Funcionario> implements IFuncionarioDAO {
    @Override
    protected Funcionario getDTO() {
        return new Funcionario();
    }
}
