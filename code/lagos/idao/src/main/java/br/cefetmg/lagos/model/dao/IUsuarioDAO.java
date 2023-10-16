package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Usuario;

public interface IUsuarioDAO {
    
    boolean inserir(Usuario usuario) throws SQLException, ClassNotFoundException;
    
    boolean alterar(Usuario usuario) throws SQLException, ClassNotFoundException;
    
    boolean remover(Usuario usuario) throws SQLException, ClassNotFoundException;
    
    List<Usuario> listar() throws SQLException, ClassNotFoundException;

}
