/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;

/**
 *
 * @author Aluno
 */
public interface IUsuarioLojaDAO extends FuncionarioDAO{
    
    void setUsername(String username);
    
    String getUsername();
    
    void setSenha(String senha);
    
    String getSenha();
    
    void setPermissoes(PermissaoUsuario[] permissoes);
    
    PermissaoUsuario[] getPermissoes();
    
    long getId();
}
