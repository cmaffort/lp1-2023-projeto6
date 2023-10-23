package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Funcionario;

public interface IFuncionarioDAO extends PessoaDAO {
    
    boolean inserir(Funcionario funcionario) throws SQLException, ClassNotFoundException;
    
    boolean alterar(Funcionario funcionario) throws SQLException, ClassNotFoundException;
   
    boolean remover(Funcionario funcionario) throws SQLException, ClassNotFoundException;
    
    List<Funcionario> listar() throws SQLException, ClassNotFoundException;
}
