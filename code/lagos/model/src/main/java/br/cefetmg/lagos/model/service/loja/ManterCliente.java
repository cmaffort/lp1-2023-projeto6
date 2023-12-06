package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.loja.IClienteDAO;
import br.cefetmg.lagos.model.dao.loja.ClienteDAO;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.loja.Cliente;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;

import java.util.List;

public class ManterCliente extends AbstractManterLojaModule<Cliente> implements IManterCliente {
    @Override
    protected IClienteDAO getDAO() {
        return new ClienteDAO();
    }

    @Override
    protected Cliente getDTOInstance() {
        return new Cliente();
    }

    public List<Cliente> pesquisarPorLoja(Loja loja) throws PersistenceException, NegocioException {
        Cliente cliente = new Cliente();

        try{
            cliente.setLoja(loja);

            return filtrar(cliente, "Loja");
        }catch (PersistenceException e ){
            throw new PersistenceException("Nenhum cliente encontrado.");
        }catch (NegocioException e){
            throw new NegocioException("Erro ao acessar o banco de dados.");
        }
    }
}
