/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;

/**
 *
 * @author miguel
 */
public interface ILojaDAO extends UsuarioContratoDAO{
    boolean inserirUsuario(UsuarioContratoDAO usuario);
    
    boolean alterarUsuario(UsuarioContratoDAO usuario);
    
    boolean removerUsuario(UsuarioContratoDAO usuario);
    
    UsuarioDAO listarUsuario();
    
    boolean inserirEndereco(EnderecoDAO endereco);
    
    boolean alterarEndereco(EnderecoDAO endereco);
    
    boolean removerEndereco(EnderecoDAO endereco);
    
    EnderecoDAO listarEndereco();
    
    boolean inserirLoja(LojaDAO loja);
    
    boolean removerLoja(LojaDAO loja);
    
    boolean alterarLoja(LojaDAO loja);
    
    LojaDAO[] listarLojas();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
