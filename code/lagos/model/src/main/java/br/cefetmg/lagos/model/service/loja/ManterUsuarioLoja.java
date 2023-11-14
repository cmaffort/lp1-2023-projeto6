package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.loja.IUsuarioLojaDAO;
import br.cefetmg.lagos.model.dao.loja.UsuarioLojaDAO;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.dto.loja.Funcionario;
import br.cefetmg.lagos.model.dto.loja.Produto;
import br.cefetmg.lagos.model.dto.loja.PromocoesProdutos;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;
import br.cefetmg.lagos.util.PasswordAuthentication;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ManterUsuarioLoja extends AbstractManterLojaModule<UsuarioLoja> implements IManterUsuarioLoja {
    @Override
    protected IUsuarioLojaDAO getDAO() {
        return new UsuarioLojaDAO();
    }

    @Override
    protected UsuarioLoja getDTOInstance() {
        return new UsuarioLoja();
    }
    
    protected boolean isOldEnough(Date birthday) {
        return LocalDate.now().minusYears(14).isAfter(birthday.toLocalDate());
    }
    
    protected void assertOldEnough(Date birthday) throws NegocioException {
        if (!isOldEnough(birthday))
            throw new NegocioException("O usuario da loja deve ter ao menos 14 anos para poder tem uma conta na loja.");
    }

    protected boolean isTelephoneValid(Long telephone) {
        if (telephone == null)
            return true;
        int len = telephone.toString().length();
        return len == 10 || len == 11;
    }

    protected void assertTelephoneIsValid(Long telephone) throws NegocioException {
        if (!isTelephoneValid(telephone))
            throw new NegocioException("O telefone deve ter entre 10 e 11 digitos.");
    }

    protected boolean isEmailValid(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{1,}$");
    }

    protected void assertEmailIsValid(String email) throws NegocioException {
        if (!isEmailValid(email))
            throw new NegocioException("O dado passado no campo de email não é um email.");
    }

    /**
     * Ao cadastrar um usuario a senha já sofre o hash.
     */
    @Override
    public Long cadastrar(UsuarioLoja usuarioLoja) throws PersistenceException, NegocioException {
        assertHasNotNullFieldsButPk(usuarioLoja);
        assertOldEnough(usuarioLoja.getNascimento());
        assertTelephoneIsValid(usuarioLoja.getTelefone());
        assertEmailIsValid(usuarioLoja.getEmail());
        PasswordAuthentication pa = new PasswordAuthentication();
        usuarioLoja.setSenha(pa.hash(usuarioLoja.getSenha()));
        return getDAO().inserir(usuarioLoja);
    }

    public boolean autenticar(UsuarioLoja usuarioLoja) throws PersistenceException, NegocioException {
        assertIdIsNotNull(usuarioLoja.getId());

        PasswordAuthentication pa = new PasswordAuthentication();

        UsuarioLoja usuarioLojaSalvo = pesquisarPorId(usuarioLoja.getId());
        if (pa.authenticate(usuarioLoja.getSenha(), usuarioLojaSalvo.getSenha())) {
            usuarioLoja.setSenha(usuarioLojaSalvo.getSenha());
            return true;
        }

        return false;
    }

    @Override
    protected List<UsuarioLoja> pesquisarPorLojaNotRelated(Loja loja) throws PersistenceException, NegocioException {
        try {
            return pesquisarPorQualquerDosRelacionados((new ManterFuncionario()).pesquisarPorLoja(loja).toArray(new Funcionario[0]));
        } catch (NegocioException negocioException) {
            return List.of();
        }
    }
}
