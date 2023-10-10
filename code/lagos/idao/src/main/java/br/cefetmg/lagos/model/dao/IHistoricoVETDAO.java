/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.lagos.model.dao;
import br.cefetmg.lagos.model.dto.tipos.TipoHistoricoVET;
import java.util.Date;
/**
 *
 * @author miguel
 */
public interface IHistoricoVETDAO extends ItemDAO{
    boolean inserirTipo(TipoHistoricoVET tipo);
    
    boolean alterarTipo(TipoHistoricoVET tipo);
    
    boolean removerTipo(TipoHistoricoVET tipo);
    
    TipoHistoricoVET listarTipo();
    
    boolean inserirData(Date data);
    
    boolean alterarData(Date data);
    
    boolean removerData(Date data);
    
    Date listarData();
    
    boolean inserirItem(ItemDAO[] item);
    
    boolean alterarItem(ItemDAO[] item);
    
    boolean removerItem(ItemDAO[] item);
    
    ItemDao[] listarItens();
    
    boolean inserirId(int id);
    
    boolean removerId(int id);
    
    int listarId();
}