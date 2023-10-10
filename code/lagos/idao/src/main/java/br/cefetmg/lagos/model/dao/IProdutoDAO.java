/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;

/**
 *
 * @author miguel
 */
public interface IProdutoDAO extends PromocaoDAO{
    boolean inserirCodigo(String codigo);
    
    boolean alterarCodigo(String codigo);
    
    boolean removerCodigo(String codigo);
    
    String listarCodigo();
    
    boolean inserirNomeProduto(String nomeProduto);
    
    boolean alterarNomeProduto(String nomeProduto);
    
    boolean removerNomeProduto(String nomeProduto);
    
    String listarNomeProduto();
    
    boolean inserirQuantidade(int quantidade);
    
    boolean alterarQuantidade(int quantidade);
    
    boolean removerQuantidade(int quantidade);
    
    int listarQuantidade();
    
    boolean inserirPreco(double preco);
    
    boolean alterarPreco(double preco);
    
    boolean removerPreco(double preco);
    
    double listarPreco();
    
    boolean inserirPromocao(PromocaoDAO promocao);
    
    boolean alterarPromocao(PromocaoDAO promocao);
    
    boolean removerPromocao(PromocaoDAO promocao);
    
    PromocaoDAO listarPromocao();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
