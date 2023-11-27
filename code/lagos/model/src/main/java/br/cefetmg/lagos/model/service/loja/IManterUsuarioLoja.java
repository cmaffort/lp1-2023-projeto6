package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.loja.base.IManterLojaModule;

public interface IManterUsuarioLoja extends IManterLojaModule<UsuarioLoja> {
    boolean autenticar(UsuarioLoja usuarioLoja) throws PersistenceException, NegocioException;

    UsuarioLoja pesquisarPorUsername(String username) throws PersistenceException, NegocioException;
}
