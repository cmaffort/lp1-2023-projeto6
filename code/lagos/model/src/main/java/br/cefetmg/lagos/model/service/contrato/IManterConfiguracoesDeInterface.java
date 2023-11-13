package br.cefetmg.lagos.model.service.contrato;

import br.cefetmg.lagos.model.service.base.IManter;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.ConfiguracoesDeInterface;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.exception.NegocioException;

public interface IManterConfiguracoesDeInterface extends IManter<ConfiguracoesDeInterface> {
    ConfiguracoesDeInterface pesquisarPorContratante(Usuario usuario) throws NegocioException, PersistenceException;
}
