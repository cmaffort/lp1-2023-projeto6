package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.loja.IClienteDAO;
import br.cefetmg.lagos.model.dao.loja.ClienteDAO;
import br.cefetmg.lagos.model.dto.loja.Cliente;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;

public class ManterCliente extends AbstractManterLojaModule<Cliente> implements IManterCliente {
    @Override
    protected IClienteDAO getDAO() {
        return new ClienteDAO();
    }

    @Override
    protected Cliente getDTOInstance() {
        return new Cliente();
    }
}
