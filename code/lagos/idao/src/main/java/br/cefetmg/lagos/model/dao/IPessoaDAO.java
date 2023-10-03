/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;
import java.util.Date;
/**
 *
 * @author Aluno
 */
public interface IPessoaDAO {
    void setNome (String nome);
    
    String getNome();
    
    void setSobrenome(String sobrenome);
    
    String getSobrenome();
    
    void setData(Date data);
    
    Date getData();
    
    void setEmail(String email);
    
    String getEmail();
    
    void setTelefone(double telefone);
    
    double getTelefone();
    
    long getId();
}
