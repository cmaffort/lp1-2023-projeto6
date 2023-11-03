package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.EnderecoDAO;
import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.IEnderecoDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Endereco;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.contrato.Usuario;

import java.util.List;
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
