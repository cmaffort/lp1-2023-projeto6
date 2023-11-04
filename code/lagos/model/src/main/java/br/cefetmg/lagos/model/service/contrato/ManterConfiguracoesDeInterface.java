package br.cefetmg.lagos.model.service.contrato;

import br.cefetmg.lagos.model.base.AbstractManter;
import br.cefetmg.lagos.model.dao.contrato.ConfiguracoesDeInterfaceDAO;
import br.cefetmg.lagos.model.dao.contrato.IConfiguracoesDeInterfaceDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.ConfiguracoesDeInterface;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.exception.NegocioException;

public class ManterConfiguracoesDeInterface extends AbstractManter<ConfiguracoesDeInterface> implements IManterConfiguracoesDeInterface {
    @Override
    protected IConfiguracoesDeInterfaceDAO getDAO() {
        return new ConfiguracoesDeInterfaceDAO();
    }

    @Override
    protected ConfiguracoesDeInterface getDTOInstance() {
        return new ConfiguracoesDeInterface();
    }

    @Override
    public ConfiguracoesDeInterface pesquisarPorContratante(Usuario usuario) throws NegocioException, PersistenceException {
        return pesquisarPorRelacionado(usuario).get(0);
    }
}
