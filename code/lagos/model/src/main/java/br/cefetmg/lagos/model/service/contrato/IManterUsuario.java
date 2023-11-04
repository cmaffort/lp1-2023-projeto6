package br.cefetmg.lagos.model.service.contrato;

import br.cefetmg.lagos.model.base.IManter;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.exception.NegocioException;

public interface IManterUsuario extends IManter<Usuario> {
    Usuario pesquisarPorPessoa(Pessoa pessoa) throws PersistenceException;
}
