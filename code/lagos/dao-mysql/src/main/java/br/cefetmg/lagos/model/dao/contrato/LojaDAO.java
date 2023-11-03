package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dao.EnderecoDAO;
import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dto.contrato.Loja;

import java.util.Map;

public class LojaDAO extends AbstractDAO<Loja> implements ILojaDAO {
    private static final EnderecoDAO ENDERECO_DAO;
    private static final UsuarioDAO USUARIO_DAO;
    
    static {
        ENDERECO_DAO = new EnderecoDAO();
        USUARIO_DAO = new UsuarioDAO();
    }
    
    @Override
    protected Loja getDTO() {
        return new Loja();
    }

    @Override
    protected Map<String, IDAO> getDAOs() {
        return Map.ofEntries(
                Map.entry("usuario", USUARIO_DAO),
                Map.entry("endereco", ENDERECO_DAO)
        );
    }
}
