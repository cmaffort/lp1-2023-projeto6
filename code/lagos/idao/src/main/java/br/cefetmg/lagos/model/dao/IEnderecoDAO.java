package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Endereco;

public interface IEnderecoDAO {
    
    boolean inserir(Endereco endereco) throws SQLException, ClassNotFoundException;
    
    boolean alterar(Endereco endereco) throws SQLException, ClassNotFoundException;
    
    boolean remover(Endereco endereco) throws SQLException, ClassNotFoundException;
    
    List<Endereco> listar() throws SQLException, ClassNotFoundException;
}
