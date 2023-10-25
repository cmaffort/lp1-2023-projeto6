package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Loja;

public interface ILojaDAO {
    
    boolean inserir(Loja loja) throws SQLException, ClassNotFoundException;
    
    boolean alterar(Loja loja) throws SQLException, ClassNotFoundException;
    
    boolean remover(Loja loja) throws SQLException, ClassNotFoundException;
    
    List<Loja> listar() throws SQLException, ClassNotFoundException;
}
