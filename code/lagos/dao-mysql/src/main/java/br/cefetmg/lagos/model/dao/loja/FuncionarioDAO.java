package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.IPessoaDAO;
import br.cefetmg.lagos.model.dao.PessoaDAO;
import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dao.base.InheritDAO;
import br.cefetmg.lagos.model.dao.contrato.ILojaDAO;
import br.cefetmg.lagos.model.dao.contrato.LojaDAO;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.loja.Funcionario;

import java.util.Map;

public class FuncionarioDAO extends InheritDAO<Funcionario, Pessoa> implements IFuncionarioDAO {
    private static final IPessoaDAO PESSOA_DAO;
    private static final ILojaDAO LOJA_DAO;

    static {
        PESSOA_DAO = new PessoaDAO();
        LOJA_DAO = new LojaDAO();
    }

    @Override
    protected Funcionario getDTO() {
        return new Funcionario();
    }

    @Override
    protected Map<String, IDAO> getDAOs() {
        return Map.ofEntries(
                Map.entry("pessoa", PESSOA_DAO),
                Map.entry("loja", LOJA_DAO)
        );
    }

    @Override
    protected IPessoaDAO getSuperDAO() {
        return PESSOA_DAO;
    }

    @Override
    protected Pessoa getInheritDTOInstance() {
        return new Pessoa();
    }

    @Override
    protected Pessoa callGetSuper(Funcionario dto) {
        return dto.getPessoa();
    }
}
