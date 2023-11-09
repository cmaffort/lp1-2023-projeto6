package br.cefetmg.lagos.model.service.contrato;

import br.cefetmg.lagos.model.service.base.AbstractManter;
import br.cefetmg.lagos.model.dao.contrato.CartaoDAO;
import br.cefetmg.lagos.model.dao.contrato.ICartaoDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Cartao;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.exception.NegocioException;

import java.util.List;

public class ManterCartao extends AbstractManter<Cartao> implements IManterCartao {
    @Override
    protected ICartaoDAO getDAO() {
        return new CartaoDAO();
    }

    @Override
    protected Cartao getDTOInstance() {
        return new Cartao();
    }

    @Override
    public List<Cartao> pesquisarPorContratante(Usuario usuario) throws NegocioException, PersistenceException {
        return null;
    }
}
