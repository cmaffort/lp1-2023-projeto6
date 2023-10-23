package br.cefetmg.lagos.model.service;

import java.util.Date;
import java.util.List;

public class Cliente {
    private Cliente cliente;
    
    public String getInstagram(){
        return cliente.getInstagram();
    }
    
    public boolean setInstagram(String instagram){
        cliente.setInstagram(instagram);
        if(ClienteDAO.inserir(cliente))
            return true;
        return false;
    }
    
    public Date getCadastro(){
        return cliente.getCliente();
    }
    
    public boolean setCadastro(Date cadastro){
        cliente.setCadastro(cadastro);
        if(ClienteDAO.inserir(cliente))
            return true;
        return false;
    }
    
    public List<Venda> getVenda(){
        return cliente.getVenda();
    }
    
    public boolean setVenda(List<Venda> venda){
        cliente.setVenda(venda);
        if(ClienteDAO.inserir(cliente))
            return true;
        return false;
    }
    
    public Loja getLoja(){
        return cliente.getLoja();
    }
    
    public boolean setLoja(Loja loja){
        cliente.setLoja(loja);
        if(ClienteDAO.inserir(cliente))
            return true;
        return false;
    }
    
    public Long getId(){
        return cliente.getId();
    }
    
    public boolean setId(Long id){
        cliente.setId(id);
        if(ClienteDAO.inserir(cliente))
            return true;
        return false;
    }
    
}
