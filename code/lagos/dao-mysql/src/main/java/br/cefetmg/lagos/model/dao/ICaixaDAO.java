/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;
/**
 *
 * @author miguel
 */
public interface ICaixaDAO extends UsuarioLojaDAO{
    boolean inserirEstadoCaixa(boolean estadoCaixa);

    boolean alterarEstadoCaixa(boolean estadoCaixa);
    
    boolean removerEstadoCaixa(boolean estadoCaixa);
    
    boolean listarEstadoCaixa();
    
    boolean inserirCaixeiro(UsuarioLojaDAO caixeiro);
    
    boolean alterarCaixeiro(UsuarioLojaDAO caixeiro);
    
    boolean removerCaixeiro(UsuarioLojaDAO caixeiro);
    
    UsuarioLojaDAO listarCaixeiro();
    
    boolean inserirDinheiroEmCaixa(double dinheiroEmCaixa);
    
    boolean alterarDinheiroEmCaixa(double dinheiroEmCaixa);
    
    double listarDinheiroEmCaixa();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
