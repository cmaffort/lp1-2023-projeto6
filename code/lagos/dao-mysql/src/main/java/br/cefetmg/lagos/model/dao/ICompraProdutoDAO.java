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
public interface ICompraProdutoDAO extends CompraDAO{
    boolean inserirDataChegada(Date data);
    
    boolean removerDataChegada(Date data);
    
    Date listarDateChegada();
    
    boolean inserirDataCompra(Date data);
    
    boolean removerDataCompra(Date data);
    
    Date listarDataCompra();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}