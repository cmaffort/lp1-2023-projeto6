package br.cefetmg.lagos.model.service;

import java.util.Date;
import java.util.List;

import br.cefetmg.lagos.model.dto.Cliente;
import br.cefetmg.lagos.model.dao.ClienteDAO;
import br.cefetmg.lagos.model.service.exception.DadoException;
import java.util.List;

public class ManagerCliente{

    private Cliente cliente;

    public boolean cadastrar(Cliente cliente) throws DadoException{
       if(cliente.getCadastro() == null){
        throw new DadoException("Obrigatório informar a data de cadastro.");
       }
       
       if(cliente.getId() == null){
        throw new DadoException("Obrigatorio informar o id do cliente.");
       }
       
       if(cliente.getLoja() == null){
           throw new DadoException("Obrigatorio informar a loja em que o cliente esta sendo cadastrado.");
       }
       
       return ClienteDAO.inserir(cliente);
    }
    
    public boolean alterar(Cliente cliente) throws DadoException{
        if(cliente.getCadastro() == null){
        throw new DadoException("Obrigatório informar a data de cadastro.");
       }
       
       if(cliente.getId() == null){
        throw new DadoException("Obrigatorio informar o id do cliente.");
       }
       
       if(cliente.getLoja() == null){
           throw new DadoException("Obrigatorio informar a loja em que o cliente esta sendo cadastrado.");
       }
       
       return ClienteDAO.alterar(cliente);
    }
    
    public List<Cliente> pesquisar(){
        return ClienteDAO.listar(cliente);
    }
    
    public Cliente pesquisarPorId(Long id){
        return ClienteDAO.listarPorId(id);
    }
}
