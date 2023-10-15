/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;

/**
 *
 * @author miguel
 */
public interface IEnderecoDAO {
    boolean inserirCEP(String CEP);
    
    boolean alterarCEP(String CEP);
    
    boolean removerCEP(String CEP);
    
    String listarCEP();
    
    boolean inserirNumeroCasa(int numeroCasa);
    
    boolean alterarNumeroCasa(int numeroCasa);
    
    boolean removerNumeroCasa(int numeroCasa);
    
    int listarNumeroCasa();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
