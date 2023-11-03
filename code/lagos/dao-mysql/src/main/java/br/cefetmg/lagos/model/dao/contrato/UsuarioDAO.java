package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.*;
import br.cefetmg.lagos.model.dao.util.InheritDAO;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.contrato.Usuario;

import java.util.Map;

public class UsuarioDAO extends InheritDAO<Usuario, Pessoa> implements IUsuarioDAO {
    private static final IPessoaDAO PESSOA_DAO;

    static {
        PESSOA_DAO = new PessoaDAO();
    }

    @Override
    protected Usuario getDTO() {
        return new Usuario();
    }

    @Override
    protected Map<String, IDAO> getDAOs() {
        return Map.ofEntries(
                Map.entry("pessoa", PESSOA_DAO)
        );
    }

    @Override
    protected IDAO getSuperDAO() {
        return PESSOA_DAO;
    }

    @Override
    protected Pessoa getInheritDTOInstance() {
        return new Pessoa();
    }

    @Override
    protected Pessoa callGetSuper(Usuario dto) {
        return dto.getPessoa();
    }
}