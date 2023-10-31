package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;

import java.util.List;

public interface IUsuarioLojaDAO extends IDAO {
    Long inserir(UsuarioLoja usuarioLoja) throws PersistenceException;
    
    boolean alterar(UsuarioLoja usuarioLoja) throws PersistenceException;
    
    boolean remover(UsuarioLoja usuarioLoja) throws PersistenceException;
    
    List<UsuarioLoja> listar() throws PersistenceException;

    List<UsuarioLoja> listar(DTO... related) throws PersistenceException;

    UsuarioLoja consultarPorId(Long id) throws PersistenceException;
}