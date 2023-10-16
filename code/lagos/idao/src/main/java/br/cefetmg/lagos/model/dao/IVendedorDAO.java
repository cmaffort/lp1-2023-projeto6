package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Vendedor;

public interface IVendedorDAO {
    
    boolean inserir(Vendedor vendedor) throws SQLException, ClassNotFoundException;
    
    boolean alterar(Vendedor vendedor) throws SQLException, ClassNotFoundException;
    
    boolean remover(Vendedor vendedor) throws SQLException, ClassNotFoundException;
    
    List<Vendedor> listar() throws SQLException, ClassNotFoundException;
}
