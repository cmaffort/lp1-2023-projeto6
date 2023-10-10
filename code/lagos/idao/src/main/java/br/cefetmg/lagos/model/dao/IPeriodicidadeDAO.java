/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;

/**
 *
 * @author miguel
 */
public interface IPeriodicidadeDAO {
    boolean inserirPeriodo(int periodo);
    
    boolean alterarPeriodo(int periodo);
    
    boolean removerPeriodo(int periodo);
    
    int listarPeriodo();
    
    boolean inserirDiasPeriodo(int diasPeriodo);
    
    boolean alterarDiasPeriodo(int diasPeriodo);
    
    boolean removerDiasPeriodo(int diasPeriodo);
    
    int listarDiasPeriodo();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
