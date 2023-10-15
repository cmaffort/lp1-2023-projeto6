/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;
import java.io.File;
import java.util.Date;
import br.cefetmg.lagos.model.dao.PeriodicidadeDAO;

/**
 *
 * @author miguel
 */
public interface IContratoDAO extends ContratoAssinadoDAO{
    boolean inserirContratoAtivo(boolean ativo);
    
    boolean alterarContratoAtivo(boolean ativo);
    
    boolean listtarContratoAtivo();
    
    boolean inserirDescricaoContrato(String descricao);
    
    boolean alterarDescricaoContrato(String descricao);
    
    boolean removerDescricaoContrato();
    
    String listarDescricaoContrato();
    
    boolean inserirPreco(double preco);
    
    boolean alterarPreco(double preco);
    
    boolean removerPreco(double preco);
    
    double listarPreco();
    
    boolean inserirdocumentosContrato(File[] documentos);
    
    boolean alterarDocumentosContrato(File[] documentos);
    
    boolean removerDocumentosContrato(File[] documentos);
    
    File[] listarDocumentosContrato();
    
    boolean inserirMulta(double multa);
    
    boolean alterarMulta(double multa);
    
    boolean removerMulta(double multa);
    
    double listarMulta();
    
    boolean inserirLojas(int lojas);
    
    boolean alterarLojas(int lojas);
    
    boolean removerLojas(int lojas);
    
    int listarLojas();
    
    boolean inserirPeriodicidade(PeriodicidadeDAO periodo);
    
    boolean alterarPeriodicidade(PeriodicidadeDAO periodo);
    
    boolean removerPeriodicidade(PeriodicidadeDAO periodo);
    
    PeriodicidadeDAO listarPeriodicidade();
    
    boolean inserirContratoAssinado(ContratoAssinadoDAO contrato);
    
    boolean alterarContratoAssinado(ContratoAssinadoDAO contrato);
    
    boolean removerContratoAssinado(ContratoAssinadoDAO contrato);
    
    ContratoAssinadoDAO listarContratoAssinado();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
