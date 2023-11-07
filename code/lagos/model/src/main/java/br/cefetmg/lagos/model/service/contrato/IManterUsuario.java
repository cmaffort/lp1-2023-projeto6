package br.cefetmg.lagos.model.service.contrato;

import br.cefetmg.lagos.model.base.IManter;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.exception.NegocioException;

public interface IManterUsuario extends IManter<Usuario> {
    Usuario pesquisarPorPessoa(Pessoa pessoa) throws PersistenceException;

    /**
     * Pega o usuario do banco de dados conferindo se a senha está correta, se estiver altera a senha do usuário passado para
     * a senha hasheada, salva no banco, e retorna true, senão não altera o usuário passado e retorna false.
     */
    public boolean autenticar(Usuario usuario) throws PersistenceException, NegocioException;
}
