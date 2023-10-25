package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Cliente;

public interface IClienteDAO {
    
    boolean inserir(Cliente cliente) throws SQLException, ClassNotFoundException;
    
    boolean alterar(Cliente cliente) throws SQLException, ClassNotFoundException;
    
    boolean remover(Cliente cliente) throws SQLException, ClassNotFoundException;
    
    List<Cliente> listar() throws SQLException, ClassNotFoundException;
}
