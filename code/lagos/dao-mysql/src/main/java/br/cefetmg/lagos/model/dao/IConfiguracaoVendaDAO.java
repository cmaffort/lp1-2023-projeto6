/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;
import br.cefetmg.lagos.model.dto.tipos.MetodosPagamento;
import br.cefetmg.lagos.model.dto.tipos.Bandeira;
/**
 *
 * @author miguel
 */
public interface IConfiguracaoVendaDAO{
    boolean inserirLimiteDesconto(float limiteDesconto);
    
    boolean alterarLimiteDesconto(float limiteDesconto);
    
    float listarLimiteDesconto();
    
    boolean inserirTaxaJurosEfetiva(float taxaEfetiva);
    
    boolean alterarTaxaJurosEfetiva(float taxaEfetiva);
    
    float listarTaxaJurosEfetiva();
    
    boolean inserirMetodosPagamento(MetodosPagamento[] metodosPagamento);
    
    boolean alterarMetodosPagamento(MetodosPagamento[] metodosPagamento);
    
    MetodosPagamento[] listarMetodosPagamento();
    
    boolean inserirBandeiras(Bandeira[] banderias);
    
    boolean alterarBandeiras(Bandeira[] banderias);
    
    Bandeira[] listarBandeiras();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
