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
public interface IPromocaoDeFidelidadeDAO  extends PeriodicidadeDAO{
    boolean buscarFidelidadeCliente(boolean fidelidade);
    
    boolean inserirFidelidadeCliente(boolean fidelidade);
    
    boolean alterarFidelidadeCliente(boolean fidelidade);
    
    boolean listarFidelidadeCliente();
    
    boolean inserirTaxaPromocao(float taxaPromocao);
    
    boolean alterarTaxaPromocao(float taxaPromocao);
    
    float listarTaxaPromocao();
    
    boolean inserirPeriodicidade(PeriodiciadeDAO periodo);
    
    boolean alterarPeriodicidade(PeriodicidadeDAO periodo);
    
    PeriodicidadeDAO listarPeriodicidade();
    
    boolean inserirEstadoPromocao(boolean estado);
    
    boolean alterarEstadoPromocao(boolean estado);
    
    boolean listarEstadoPromocao();
    
    boolean inserirMaximaDuracao(Date data);
    
    boolean alterarMaximaDuracao(Date data);
    
    boolean removerMaximaDuracao(Date data);
    
    Date listarMaximaDuracao();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
