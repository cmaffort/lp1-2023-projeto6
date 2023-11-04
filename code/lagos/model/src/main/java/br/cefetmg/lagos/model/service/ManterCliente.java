package br.cefetmg.lagos.model.service;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.loja.ClienteDAO;
import br.cefetmg.lagos.model.dto.loja.Cliente;
import br.cefetmg.lagos.model.exception.DadoException;

import java.util.List;

public class ManterCliente {
    private ClienteDAO clienteDAO;

    public Long cadastrar(Cliente cliente) throws DadoException, PersistenceException {
        if (cliente.getCadastro() == null) {
            throw new DadoException("Obrigatório informar a data de cadastro.");
        }

        if (cliente.getLoja() == null) {
            throw new DadoException("Obrigatorio informar a loja em que o cliente esta sendo cadastrado.");
        }

        return clienteDAO.inserir(cliente);
    }

    public boolean alterar(Cliente cliente) throws DadoException, PersistenceException {
        if (cliente.getCadastro() == null) {
            throw new DadoException("Obrigatório informar a data de cadastro.");
        }

        if (cliente.getLoja() == null) {
            throw new DadoException("Obrigatorio informar a loja em que o cliente esta sendo cadastrado.");
        }

        return clienteDAO.alterar(cliente);
    }

    public List<Cliente> pesquisar() throws PersistenceException {
        return clienteDAO.listar();
    }

    public Cliente consultarPorId(Long id) throws PersistenceException {
        return clienteDAO.consultarPorId(id);
    }

    public List<Cliente> consultarPorLoja(Long idLoja) {
        return null;

        // Cliente cliente;
        // Cliente cliente2;

        // List<Cliente> clientes = new ArrayList<>();

        // cliente.setNome("Enéas Carneiro");
        // cliente.setTelefone(21999999);
        // cliente.setEmail("enéasmitinho@gmail.com");

        // cliente2.setNome("xxxx  xxxxxxxxx");
        // cliente2.setTelefone(2196999);
        // cliente2.setEmail("XXX@gmail.com");

        // clientes.add(cliente);
        // clientes.add(cliente2);

        // return clientes;
    }
}
