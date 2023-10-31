package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.Funcionario;

import java.util.List;

public interface IFuncionarioDAO extends IDAO {
    
    boolean inserir(Funcionario funcionario) throws PersistenceException;
    
    boolean alterar(Funcionario funcionario) throws PersistenceException;
   
    boolean remover(Funcionario funcionario) throws PersistenceException;
    
    List<Funcionario> listar() throws PersistenceException;

    Funcionario consultarPorId(Long id) throws PersistenceException;
}
