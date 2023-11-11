package br.cefetmg.lagos.model.service.contrato;

import br.cefetmg.lagos.model.dao.contrato.ILojaDAO;
import br.cefetmg.lagos.model.service.base.AbstractManter;
import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dao.contrato.LojaDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.exception.NegocioException;

import java.util.List;

public class ManterLoja extends AbstractManter<Loja> implements IManterLoja {
    @Override
    protected ILojaDAO getDAO() {
        return new LojaDAO();
    }

    @Override
    protected Loja getDTOInstance() {
        return new Loja();
    }

    @Override
    public List<Loja> pesquisarPorContratante(Usuario usuario) throws NegocioException, PersistenceException {
        return pesquisarPorRelacionado(usuario);
    }

    @Override
    public long countLojas(Usuario usuario) throws NegocioException, PersistenceException {
        assertIdIsNotNull(usuario.getId());
        return getDAO().countLojas(usuario);
    }
}
