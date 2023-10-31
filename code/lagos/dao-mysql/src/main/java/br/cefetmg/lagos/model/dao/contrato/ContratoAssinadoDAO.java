package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.contrato.Usuario;

import java.util.Arrays;
import java.util.List;

public class ContratoAssinadoDAO extends AbstractDAO implements IContratoAssinadoDAO {
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
    protected DTO getDTO() {
        return new ContratoAssinado();
    }

    @Override
    public Long inserir(ContratoAssinado contratoAssinado) throws PersistenceException {
        return super.inserir(contratoAssinado);
    }

    @Override
    public boolean alterar(ContratoAssinado contratoAssinado) throws PersistenceException {
        return super.alterar(contratoAssinado);
    }

    @Override
    public boolean remover(ContratoAssinado contratoAssinado) throws PersistenceException {
        return super.remover(contratoAssinado);
    }

    @Override
    protected List<String> getOrderByPriority() {
        return List.of("data_de_contratacao");
    }

    private ContratoAssinado fillRelatedDTOs(ContratoAssinado contratoAssinado) throws PersistenceException {
        IUsuarioDAO usuarioDAO = getUsuarioDao();
        IContratoDAO contratoDAO = getContratoDao();

        Usuario usuario = usuarioDAO.consultarPorId(contratoAssinado.getUsuarioAsLong());
        Contrato contrato = contratoDAO.consultarPorId(contratoAssinado.getContratoAsLong());

        contratoAssinado.setUsuario(usuario);
        contratoAssinado.setContrato(contrato);

        return contratoAssinado;
    }

    private List<ContratoAssinado> fillRelatedDTOs(List<ContratoAssinado> contratosAssinados) throws PersistenceException {
        for (ContratoAssinado contratoAssinado : contratosAssinados)
            fillRelatedDTOs(contratoAssinado);
        return contratosAssinados;
    }

    @Override
    public List<ContratoAssinado> listar() throws PersistenceException {
        return fillRelatedDTOs((List<ContratoAssinado>) super.listar());
    }

    @Override
    public List<ContratoAssinado> listar(DTO... dto) throws PersistenceException {
        return fillRelatedDTOs((List<ContratoAssinado>) super.listar(dto));
    }

    @Override
    public ContratoAssinado consultarPorId(Long id) throws PersistenceException {
        return fillRelatedDTOs((ContratoAssinado) super.consultarPorId(id));
    }

    @Override
    public ContratoAssinado consultarPor(DTO... related) throws PersistenceException {
        return fillRelatedDTOs((ContratoAssinado) super.consultarPor(related));
    }
}
