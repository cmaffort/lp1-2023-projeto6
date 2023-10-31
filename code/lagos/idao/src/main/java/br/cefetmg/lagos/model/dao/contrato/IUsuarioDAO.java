package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Usuario;

import java.util.List;

public interface IUsuarioDAO extends IDAO {
    Long inserir(Usuario usuario) throws PersistenceException;
    
    boolean alterar(Usuario usuario) throws PersistenceException;
    
    boolean remover(Usuario usuario) throws PersistenceException;
    
    List<Usuario> listar() throws PersistenceException;

    Usuario consultarPorId(Long id) throws PersistenceException;
}
