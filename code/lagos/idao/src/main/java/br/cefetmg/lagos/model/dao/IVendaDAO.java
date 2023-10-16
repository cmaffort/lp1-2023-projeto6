package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Venda;

public interface IVendaDAO extends HistoricoVETDAO{
    
    boolean inserir(Venda venda) throws SQLException, ClassNotFoundException;
    
    boolean alterar(Venda venda) throws SQLException, ClassNotFoundException;
    
    boolean remover(Venda venda) throws SQLException, ClassNotFoundException;
    
    List<Venda> listar() throws SQLException, ClassNotFoundException;
}
