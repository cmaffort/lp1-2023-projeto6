/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;

/**
 *
 * @author miguel
 */
public interface IPromocaoDAO extends PeriodicidadeDAO{
    
    boolean inserirTaxaPromocao(float taxaPromocao);
    
    boolean alterarTaxaPromocao(float taxaPromocao);
    
    float listarTaxaPromocao();
    
    boolean inserirPeriodicidade(PeriodiciadeDAO periodo);
    
    boolean alterarPeriodicidade(PeriodicidadeDAO periodo);
    
    PeriodicidadeDAO listarPeriodicidade();
    
    boolean inserirEstadoPromocao(boolean estado);
    
    boolean alterarEstadoPromocao(boolean estado);
    
    boolean listarEstadoPromocao();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
