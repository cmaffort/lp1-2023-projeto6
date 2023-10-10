/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;

import java.util.Date;

/**
 * @author miguel
 */
public interface IPessoaDAO {
    boolean inserirNome(String nome);
    
    boolean removerNome(String nome);

    String listarNome();

    boolean inserirSobrenome(String sobrenome);
    
    boolean removerSobrenome(String sobrenome);

    String listarSobrenome();

    boolean inserirNascimento(Date nascimento);
    
    boolean removerNascimento(Date nascimento);

    Date listarNascimento();

    boolean inserirEmail(String email);
    
    boolean alterarEmail(String email);
    
    boolean removerEmail(String email);

    String listarEmail();

    boolean inserirTelefone(long telefone);
    
    boolean alterarTelefone(long telefone);
    
    boolean removerTelefone(long telefone);

    long listarTelefone();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
