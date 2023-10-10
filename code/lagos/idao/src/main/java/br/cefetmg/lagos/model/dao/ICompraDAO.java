/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;
/**
 *
 * @author miguel
 */
public interface ICompraDAO extends ProdutoDAO{
    boolean inserirQuantidade(int quantidade);
    
    int listarQuantidade();
    
    boolean inserirPrecoUnitario(double precoUnitario);
    
    double listarPrecoUnitario();
    
    boolean inserirProduto(ProdutoDAO produto);
    
    ProdutoDAO listarProduto();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}