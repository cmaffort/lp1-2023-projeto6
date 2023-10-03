/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;

/**
 *
 * @author Aluno
 */
public interface IFuncionarioDAO extends PessoaDAO{
    void setSalario(double salario);
    
    double getSalario();
    
    void setAtivo (Boolean ativo);
    
    Boolean getAtivo();
    
    void setComissao(double comissao);
    
    double getComissao();
    
    void setTipoFuncionario(TipoFuncionario tipoFuncionario);
    
    TipoFuncionario getTipoFuncionario();
    
    long getId();
}
