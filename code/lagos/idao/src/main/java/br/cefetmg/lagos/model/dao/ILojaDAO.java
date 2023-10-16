/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;

/**
 *
 * @author miguel
 */
public interface ILojaDAO extends UsuarioDAO{
    boolean inserirUsuario(UsuarioDAO usuario);
    
    boolean alterarUsuario(UsuarioDAO usuario);
    
    boolean removerUsuario(UsuarioDAO usuario);
    
    UsuarioDAO listarUsuario();
    
    boolean acessarLoja(long id);
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
