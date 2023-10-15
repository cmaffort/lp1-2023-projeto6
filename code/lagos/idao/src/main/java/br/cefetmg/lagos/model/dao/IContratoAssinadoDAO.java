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
public interface IContratoAssinadoDAO extends UsuárioContratoDAO{
    
    boolean inserirAtividade(boolean vigente);
    
    boolean alterarAtividade(boolean vigente);
    
    boolean listarAtividade();
    
    boolean inserirDataContratacao(Date data);
    
    boolean alterarDataContratacao(Date data);
    
    Date listarDataContratacao();
    
    boolean inserircontratoCancelado(boolean contratoCancelado);
    
    boolean alterarcontratoCancelado(boolean contratoCancelado);
    
    boolean listarContratoCancelado();
    
    boolean inserirUsuário(UsuárioContratoDAO usuario);
    
    boolean removerUsuario(UsuárioContratoDAO usuario);
    
    UsuárioContratoDAO listarUsuario();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
