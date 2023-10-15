/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;
/**
 *
 * @author migue
 */
public interface IFluxoTotalCaixaDAO extends FluxoUnitarioCaixaDAO{
    boolean inserirDinheiroCaixa(FluxoUnitarioCaixaDAO fluxo);
    
    boolean alterarDinheiroCaixa(FluxoUnitarioCaixaDAO fluxo);
    
    boolean removerDinheiroCaixa(FluxoUnitarioCaixaDAO fluxo);
    
    FluxoUnitarioCaixaDAO listarDinheiroCaixa();    
}
