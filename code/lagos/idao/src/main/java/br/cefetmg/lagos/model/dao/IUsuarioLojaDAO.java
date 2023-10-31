package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;
import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;

public interface IUsuarioLojaDAO  {

    boolean inserir(UsuarioLoja usuarioLoja) throws SQLException, ClassNotFoundException;
    
    boolean alterar(UsuarioLoja usuarioLoja) throws SQLException, ClassNotFoundException;
    
    boolean remover(UsuarioLoja usuarioLoja) throws SQLException, ClassNotFoundException;
    
    List<UsuarioLoja> listar() throws SQLException, ClassNotFoundException;
}
