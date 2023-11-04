package br.cefetmg.lagos.model.service.contrato;

import br.cefetmg.lagos.model.base.AbstractManter;
import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dao.contrato.ContratoAssinadoDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.exception.NegocioException;

import java.util.List;

public class ManterContratoAssinado extends AbstractManter<ContratoAssinado> implements IManterContratoAssinado {
    @Override
    protected IDAO<ContratoAssinado> getDAO() {
        return new ContratoAssinadoDAO();
    }

    @Override
    protected ContratoAssinado getDTOInstance() {
        return new ContratoAssinado();
    }

    @Override
    public List<ContratoAssinado> pesquisarPorContratante(Usuario usuario) throws NegocioException, PersistenceException {
        return null;
    }

    @Override
    public List<ContratoAssinado> pesquisarPorContrato(Contrato contrato) throws NegocioException, PersistenceException {
        return null;
    }
}
