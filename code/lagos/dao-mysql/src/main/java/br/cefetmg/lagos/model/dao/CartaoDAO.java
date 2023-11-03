package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dao.contrato.UsuarioDAO;
import br.cefetmg.lagos.model.dao.contrato.IUsuarioDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Cartao;
import br.cefetmg.lagos.model.dto.Endereco;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.contrato.Usuario;

import java.util.List;
import java.util.Map;

public class CartaoDAO extends AbstractDAO<Cartao> implements ICartaoDAO {
    private static final IUsuarioDAO USUARIO_DAO;
    private static final IEnderecoDAO ENDERECO_DAO;

    static {
        USUARIO_DAO = new UsuarioDAO();
        ENDERECO_DAO = new EnderecoDAO();
    }

    @Override
    protected Cartao getDTO() {
        return new Cartao();
    }

    @Override
    protected Map<String, IDAO> getDAOs() {
        return Map.ofEntries(
                Map.entry("usuario", USUARIO_DAO),
                Map.entry("endereco", ENDERECO_DAO)
        );
    }
}
