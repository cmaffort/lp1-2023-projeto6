package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.loja.Produto;

public interface IProdutoDAO {
    
    boolean inserir(Produto produto) throws SQLException, ClassNotFoundException;
   
    boolean alterar(Produto produto) throws SQLException, ClassNotFoundException;
    
    boolean remover(Produto produto) throws SQLException, ClassNotFoundException;
    
    List<Produto> listar() throws SQLException, ClassNotFoundException;
}
