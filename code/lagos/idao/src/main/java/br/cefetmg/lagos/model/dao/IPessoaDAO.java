package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Pessoa;

public interface IPessoaDAO {
    
    boolean inserir(Pessoa pessoa)  throws SQLException, ClassNotFoundException;

    boolean alterar(Pessoa pessoa) throws SQLException, ClassNotFoundException;
    
    boolean remover(Pessoa pessoa) throws SQLException, ClassNotFoundException;
    
    List<Pessoa> listar() throws SQLException, ClassNotFoundException;
}
