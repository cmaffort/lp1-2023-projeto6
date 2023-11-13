package br.cefetmg.lagos.model.service.contrato;

import br.cefetmg.lagos.model.service.base.AbstractManter;
import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dao.contrato.*;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.exception.NegocioException;

import java.util.List;

public class ManterContrato extends AbstractManter<Contrato> implements IManterContrato {
    @Override
    public IContratoDAO getDAO() {
        return new ContratoDAO();
    }

    @Override
    protected Contrato getDTOInstance() {
        return new Contrato();
    }
    
    protected boolean usuarioHasId(Usuario usuario) {
        return usuario.getId() != null;
    }
    
    protected void assertUsuarioHasId(Usuario usuario) throws NegocioException {
        if (!usuarioHasId(usuario)) {
            throw new NegocioException("Usuario tem que ter um ID");
        }
    }

    @Override
    public List<Contrato> pesquisarPorContratante(Usuario usuario) throws NegocioException, PersistenceException {
        assertUsuarioHasId(usuario);
        return getDAO().filtrarRelated(usuario);
    }
}