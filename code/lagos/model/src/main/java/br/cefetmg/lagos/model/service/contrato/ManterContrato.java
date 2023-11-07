package br.cefetmg.lagos.model.service.contrato;

import br.cefetmg.lagos.model.base.AbstractManter;
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
    protected IContratoDAO getDAO() {
        return new ContratoDAO();
    }

    @Override
    protected Contrato getDTOInstance() {
        return new Contrato();
    }
    
    @Override
    public Long cadastrar(Contrato contrato) throws NegocioException, PersistenceException {
        return ContratoDAO.inserir(contrato);
    }

    @Override
    public boolean alterar(Contrato contrato) throws NegocioException, PersistenceException {
        return ContratoDAO.alterar(contrato);
    }

    @Override
    public List<Contrato> consultar() throws PersistenceException {
        return ContratoDAO.listar();
    }

    @Override
    public Contrato consultarPorId(Long id) throws PersistenceException {
        return ContratoDAO.consultarPorId(id);
    }

    @Override
    public List<Contrato> consultarPorLoja(Long idLoja) {
        return null;
    }

    @Override
    public List<Contrato> pesquisarPorContratante(Usuario usuario) throws NegocioException, PersistenceException {
        // TODO: Fazer verificações
        return getDAO().filtrarRelated(usuario);
    }
}