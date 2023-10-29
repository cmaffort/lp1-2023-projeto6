package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.Usuario;

public interface IUsuarioDAO extends IDAO {
    Long inserir(Usuario usuario) throws PersistenceException;
    
    boolean alterar(Usuario usuario) throws PersistenceException;
    
    boolean remover(Usuario usuario) throws PersistenceException;
    
    List<Usuario> listar() throws PersistenceException;

    Usuario cosultarPorId(Long id) throws PersistenceException;
}
