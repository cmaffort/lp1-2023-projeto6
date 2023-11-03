package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dto.loja.Cliente;

public class ClienteDAO extends AbstractDAO<Cliente> implements IClienteDAO {
    @Override
    protected Cliente getDTO() {
        return new Cliente();
    }
}
