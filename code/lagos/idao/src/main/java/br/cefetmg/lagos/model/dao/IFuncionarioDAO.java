/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dto.tipos.TipoFuncionario;

/**
 * @author miguel
 */
public interface IFuncionarioDAO extends PessoaDAO {
    boolean inserirSalario(double salario);
    
    boolean alterarSalario(double salario);
    
    boolean removerSalario(double salario);

    double listarSalario();

    boolean inserirEstado(boolean ativo);
    
    boolean alterarEstado(boolean ativo);
    
    boolean removerEstado(boolean ativo);

    boolean listarEstado();

    boolean inserirComissao(double comissao);
    
    boolean alterarComissoa(double comissao);
    
    boolean removerComissoa(double comissao);

    double listarComissao();

    boolean inserirTipoFuncionario(TipoFuncionario tipoFuncionario);
    
    boolean alterarTipoFuncionario(TipoFuncionario tipoFuncionario);
    
    boolean removerTipoFuncionario(TipoFuncionario tipoFuncionario);

    TipoFuncionario listarTipoFuncionario();
    
    boolean inserirPessoa(PessoaDAO pessoa);
    
    boolean alterarPessoa(PessoaDAO pessoa);
    
    boolean removerPessoa(PessoaDAO pessoa);
    
    PessoaDAO listarPessoa();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
