package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dao.base.InheritDAO;
import br.cefetmg.lagos.model.dto.loja.Funcionario;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;

import java.util.Map;

public class UsuarioLojaDAO extends InheritDAO<UsuarioLoja, Funcionario> implements IUsuarioLojaDAO {
    @Override
    protected UsuarioLoja getDTO() {
        return new UsuarioLoja();
    }

    private static final IFuncionarioDAO FUNCIONARIO_DAO;

    static {
        FUNCIONARIO_DAO = new FuncionarioDAO();
    }

    @Override
    protected Map<String, IDAO> getDAOs() {
        return Map.ofEntries(
                Map.entry("funcionario", FUNCIONARIO_DAO)
        );
    }

    @Override
    protected IFuncionarioDAO getSuperDAO() {
        return FUNCIONARIO_DAO;
    }

    @Override
    protected Funcionario getInheritDTOInstance() {
        return new Funcionario();
    }

    @Override
    protected Funcionario callGetSuper(UsuarioLoja usuarioLoja) {
        return usuarioLoja.getFuncionario();
    }
}
