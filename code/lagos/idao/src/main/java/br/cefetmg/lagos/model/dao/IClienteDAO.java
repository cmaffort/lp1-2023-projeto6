/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;
import java.util.Date;

/**
 * @author miguel
 */
public interface IClienteDAO extends PessoaDAO{
    boolean inserirPessoa(PessoaDAO pessoa);
    
    boolean removerPessoa(PessoaDAO pessoa);
    
    PessoaDAO listarPessoa();
    
    boolean inserirInstagram(String instagram);
    
    boolean alterarInstagram(String instagram);
    
    boolean removerInstagram(String instagram);
    
    String listarInstagram();
    
    boolean inserirCadastro(Date cadastro);
    
    boolean removerCadastro(Date cadastro);
    
    Date listarCadastro();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
