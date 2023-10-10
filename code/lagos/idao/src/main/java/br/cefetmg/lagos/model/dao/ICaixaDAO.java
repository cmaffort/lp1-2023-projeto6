/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;

/**
 *
 * @author miguel
 */
public interface ICaixaDAO extends UsuarioDAO{
    boolean inserirEstadoCaixa(boolean estadoCaixa);

    boolean alterarEstadoCaixa(boolean estadoCaixa);
    
    boolean removerEstadoCaixa(boolean estadoCaixa);
    
    boolean listarEstadoCaixa();
    
    boolean inserirDinheiroEmCaixa(double dinheiroEmCaixa);
    
    boolean alterarDinheiroEmCaixa(double dinheiroEmCaixa);
    
    double listarDinheiroEmCaixa();
    
    boolean inserirUsuario(UsuarioDAO usuario);
    
    boolean alterarUsuario(UsuarioDAO usuario);
    
    boolean removerUsuario(UsuarioDAO usuario);
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
