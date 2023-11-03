package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.Cliente;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.List;

public class ClienteDAO extends AbstractDAO<Cliente> implements IClienteDAO {
    @Override
    protected Cliente getDTO() {
        return new Cliente();
    }
}
