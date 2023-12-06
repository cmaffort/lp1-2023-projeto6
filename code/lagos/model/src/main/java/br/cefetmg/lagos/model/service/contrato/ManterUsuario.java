package br.cefetmg.lagos.model.service.contrato;

import br.cefetmg.lagos.model.dto.exceptions.DTOExeption;
import br.cefetmg.lagos.model.service.base.AbstractManter;
import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dao.contrato.UsuarioDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.util.PasswordAuthentication;

import java.util.List;
import java.util.Map;

public class ManterUsuario extends AbstractManter<Usuario> implements IManterUsuario {
    @Override
    protected IDAO<Usuario> getDAO() {
        return new UsuarioDAO();
    }

    @Override
    protected Usuario getDTOInstance() {
        return new Usuario();
    }

    /**
     * Ao cadastrar um usuario a senha já sofre o hash.
     */
    @Override
    public Long cadastrar(Usuario usuario) throws PersistenceException, NegocioException {
        assertHasNotNullFieldsButPk(usuario);
        PasswordAuthentication pa = new PasswordAuthentication();
        usuario.setSenha(pa.hash(usuario.getSenha()));
        return getDAO().inserir(usuario);
    }

    public boolean autenticar(Usuario usuario) throws PersistenceException, NegocioException {
        assertIdIsNotNull(usuario.getId());

        PasswordAuthentication pa = new PasswordAuthentication();

        Usuario usuarioSalvo = pesquisarPorId(usuario.getId());
        if (pa.authenticate(usuario.getSenha(), usuarioSalvo.getSenha())) {
            usuario.setSenha(usuarioSalvo.getSenha());
            return true;
        }

        return false;
    }

    @Override
    public Usuario pesquisarPorPessoa(Pessoa pessoa) throws PersistenceException {
        return pesquisarPorId(pessoa.getId());
    }

    protected void assertUsernameIsNotNull(String username) throws NegocioException {
        if (username == null)
            throw new NegocioException("O nome de usuário deve ser atribuído.");
    }

    public Usuario pesquisarPorUser(String username) throws NegocioException, PersistenceException{
        assertUsernameIsNotNull(username);

        try{
            Usuario usuario = getDTOInstance().getInstance(Map.of("username", username));
            List<Usuario> usuarioList = filtrar(usuario, "username");
            return usuarioList.get(0);
        } catch (IndexOutOfBoundsException | NegocioException | DTOExeption e) {
            throw new NegocioException("O usuário de nome de usuário: " + username + " não existe.", e);
        }
    }
}
