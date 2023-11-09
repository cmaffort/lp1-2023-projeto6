package br.cefetmg.lagos.model.service.contrato;

import br.cefetmg.lagos.model.service.base.AbstractManter;
import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dao.contrato.ContratoAssinadoDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.exception.NegocioException;

import java.sql.Date;
import java.time.LocalDate;
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
    public Long cadastrar(ContratoAssinado contratoAssinado) throws PersistenceException, NegocioException {
        if (contratoAssinado.isCancelado() == null)
            contratoAssinado.setCancelado(false);

        if (contratoAssinado.getDataDeContratacao() == null)
            contratoAssinado.setDataDeContratacao(Date.valueOf(LocalDate.now()));

        return super.cadastrar(contratoAssinado);
    }

    @Override
    public List<ContratoAssinado> pesquisarPorContratante(Usuario usuario) throws NegocioException, PersistenceException {
        assertIdIsNotNull(usuario.getId());
        return getDAO().filtrarRelated(usuario);
    }

    @Override
    public List<ContratoAssinado> pesquisarPorContrato(Contrato contrato) throws NegocioException, PersistenceException {
        assertIdIsNotNull(contrato.getId());
        return getDAO().filtrarRelated(contrato);
    }
}
