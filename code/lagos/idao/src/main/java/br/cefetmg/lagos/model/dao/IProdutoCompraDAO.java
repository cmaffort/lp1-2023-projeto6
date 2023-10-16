package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.ProdutoCompra;

public interface IProdutoCompraDAO {
    
    boolean inserir(ProdutoCompra produtoCompra) throws SQLException, ClassNotFoundException;
    
    boolean alterar(ProdutoCompra produtoCompra) throws SQLException, ClassNotFoundException;
    
    boolean remover(ProdutoCompra produtoCompra) throws SQLException, ClassNotFoundException;
    
    List<ProdutoCompra> listar() throws SQLException, ClassNotFoundException;
}
