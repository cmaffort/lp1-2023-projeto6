/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;
import java.io.File;
/**
 *
 * @author miguel
 */
public interface IConfiguracaoDeInterfaceDAO extends UsuarioDAO{
    boolean inserirNomeEmpresa(String nomeEmpresa);
    
    boolean alterarNomeEmpresa(String nomeEmpresa);
    
    boolean removerNomeEmpresa(String nomeEmpresa);

    String listarNomeEmpresa();
    
    boolean inserirLogo(File logo);
    
    boolean alterarLogo(File logo);
    
    boolean removerLogo(File logo);
    
    File listarLogo();
    
    boolean inserirCorBase(String corBase);
    
    boolean alterarCorBase(String corBase);
    
    boolean removerCorBase(String corBase);
    
    boolean inserirUsuario(UsuarioDAO usuario);
    
    boolean alterarUsuario(UsuarioDAO usuario);
    
    boolean removerUsuario(UsuarioDAO usuario);
    
    UsuarioDAO listarUsuario();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
