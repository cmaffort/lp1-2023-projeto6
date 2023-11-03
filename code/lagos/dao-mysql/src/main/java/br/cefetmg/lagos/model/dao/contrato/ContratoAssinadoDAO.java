package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.contrato.Usuario;

import java.util.List;
import java.util.Map;

public class ContratoAssinadoDAO extends AbstractDAO<ContratoAssinado> implements IContratoAssinadoDAO {
    private static final IUsuarioDAO USUARIO_DAO;
    private static final IContratoDAO CONTRATO_DAO;

    static {
        USUARIO_DAO = new UsuarioDAO();
        CONTRATO_DAO = new ContratoDAO();
    }

    private static IUsuarioDAO getUsuarioDao() {
        return USUARIO_DAO;
    }

    private static IContratoDAO getContratoDao() {
        return CONTRATO_DAO;
    }

    @Override
    protected ContratoAssinado getDTO() {
        return new ContratoAssinado();
    }

    @Override
    protected List<String> getOrderByPriority() {
        return List.of("data_de_contratacao");
    }

    @Override
    protected Map<String, IDAO> getDAOs() {
        return Map.ofEntries(
                Map.entry("usuario", USUARIO_DAO),
                Map.entry("contrato", CONTRATO_DAO)
        );
    }
}
