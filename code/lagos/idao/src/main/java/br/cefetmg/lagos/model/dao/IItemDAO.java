/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;

/**
 *
 * @author miguel
 */
public interface IItemDAO extends ProdutoDAO{
    boolean inserirProduto(ProdutoDAO produto);
    
    boolean removerProduto(ProdutoDAO produto);
    
    boolean inserirPreco(double preco);
    
    boolean alterarPreco(double preco);
    
    boolean removerPreco(double preco);
    
    double listarPreco();
    
    boolean inserirQuantidade(int quantidade);
    
    boolean alterarQuantidade(int quantidade);
    
    boolean removerQuantidade(int quantidade);
    
    int listarQuantidade();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
