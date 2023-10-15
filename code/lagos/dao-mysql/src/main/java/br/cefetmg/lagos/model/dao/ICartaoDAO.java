/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;
import br.cefetmg.lagos.model.dto.tipos.Bandeira;
/**
 *
 * @author miguel
 */
public interface ICartaoDAO extends UsuarioContratoDAO{    
    boolean inserirEndereco(EnderecoDAO endereco);
    
    boolean alterarEndereco(EnderecoDAO endereco);
    
    boolean removerEndereco(EnderecoDAO endereco);
    
    EnderecoDAO listarEndereco();
    
    boolean inserirNumeroCartao(long numeroCartao);
    
    boolean alterarNumeroCartao(long numeroCartao);
    
    boolean removerNumeroCartao(long numeroCartao);
    
    long listarNumeroCartao();
    
    boolean inserirBandeiraCartao(Bandeira bandeira);
    
    boolean alterarBandeiraCartao(Bandeira bandeira);
    
    boolean removerBandeiraCartao(Bandeira bandeira);
    
    Bandeira listarBandeiraCartao();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}
