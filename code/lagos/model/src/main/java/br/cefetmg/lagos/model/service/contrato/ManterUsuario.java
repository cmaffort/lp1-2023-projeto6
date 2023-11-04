package br.cefetmg.lagos.model.service.contrato;

import br.cefetmg.lagos.model.base.AbstractManter;
import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dao.contrato.UsuarioDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.contrato.Usuario;

public class ManterUsuario extends AbstractManter<Usuario> implements IManterUsuario {
    @Override
    protected IDAO<Usuario> getDAO() {
        return new UsuarioDAO();
    }

    @Override
    protected Usuario getDTOInstance() {
        return new Usuario();
    }

    @Override
    public Usuario pesquisarPorPessoa(Pessoa pessoa) throws PersistenceException {
        return pesquisarPorId(pessoa.getId());
    }
}
