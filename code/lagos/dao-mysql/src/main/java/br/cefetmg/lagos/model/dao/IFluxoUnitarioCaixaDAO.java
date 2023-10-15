/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;
import java.util.Date;
/**
 *
 * @author miguel
 */
public interface IFluxoUnitarioCaixaDAO{
    boolean inserirDinheiroCaixa(double dinheiroCaixa);
    
    boolean alterarDinheiroCaixa(double dinheiroCaixa);
    
    boolean removerDinheiroCaixa(double dinheiroCaixa);
    
    double listarDinheiroCaixa();
    
    boolean inserirData(Date data);
    
    Date listarData();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}