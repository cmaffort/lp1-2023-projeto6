package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.EnderecoDAO;
import br.cefetmg.lagos.model.dao.IEnderecoDAO;
import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dto.contrato.Cartao;

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
