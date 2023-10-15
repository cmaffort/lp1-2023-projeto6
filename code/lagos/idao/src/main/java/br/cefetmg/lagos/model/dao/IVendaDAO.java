/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;

/**
 *
 * @author miguel
 */
public interface IVendaDAO extends HistoricoVETDAO{    
    boolean inserirVendedor(FuncionarioDAO vendedor);
    
    boolean alterarVendedor(FuncionarioDAO vendedor);
    
    boolean removerVendedor(FuncionarioDAO vendedor);
    
    FuncionarioDAO listarVendedor();
    
    boolean insrirCliente(ClienteDAO cliente);
    
    boolean removerCliente(ClienteDAO cliente);
    
    ClienteDAO listarCliente();
    
    boolean inserirHistoricoVET(HistoricoVETDAO venda);
    
    boolean alterarHistoricoVET(HistoricoVETDAO venda);
    
    boolean removerHistoricoVET(HistoricoVETDAO venda);
    
    HistoricoVETDAO listarHistoricoVET();
    
    boolean inserirPromocaoFidelidade(PromocaoFidelidadeDAO promocao);
    
    boolean removerPromocaoFidelidade(PromocaoFidelidadeDAO promocao);
    
    PromocaoFidelidadeDAO listarPromocaoFidelidade();
    
    boolean inserirPromocao(PromocaoDAO promocao);
    
    boolean removerPromocao(PromocaoDAO promocao);
    
    PromocaoDAO listarPromocao();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
