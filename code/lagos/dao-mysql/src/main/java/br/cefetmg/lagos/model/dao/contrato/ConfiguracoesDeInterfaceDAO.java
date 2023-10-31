package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.ConfiguracoesDeInterface;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.contrato.Usuario;

import java.util.Arrays;
import java.util.List;

public class ConfiguracoesDeInterfaceDAO extends AbstractDAO implements IConfiguracoesDeInterfaceDAO {
    private static final IUsuarioDAO USUARIO_DAO;

    static {
        USUARIO_DAO = new UsuarioDAO();
    }

    private static IUsuarioDAO getUsuarioDao() {
        return USUARIO_DAO;
    }

    @Override
    protected DTO getDTO() {
        return new ConfiguracoesDeInterface();
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementInserir() {
        return Arrays.asList(
                Arrays.asList("nome_da_empresa", "logo", "cor_base", "pk")
        );
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementAlterar() {
        return Arrays.asList(
                Arrays.asList("nome_da_empresa", "logo", "cor_base"),
                List.of("pk")
        );
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementRemover() {
        return Arrays.asList(
                List.of("pk")
        );
    }

    @Override
    protected List<List<String>> getColumnsResultSetListar() {
        return Arrays.asList(
                Arrays.asList("nome_da_empresa", "logo", "cor_base", "pk")
        );
    }

    @Override
    protected List<String> getOrderByPriority() {
        return List.of("pk");
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementConsultar() {
        return Arrays.asList(
                List.of("pk")
        );
    }

    @Override
    protected List<List<String>> getColumnsResultSetConsultar() {
        return Arrays.asList(
                Arrays.asList("nome_da_empresa", "logo", "cor_base", "pk")
        );
    }

    @Override
    public Long inserir(ConfiguracoesDeInterface configuracoesDeInterface) throws PersistenceException {
        super.inserir(configuracoesDeInterface);
        return configuracoesDeInterface.getId();
    }

    @Override
    public boolean alterar(ConfiguracoesDeInterface configuracoesDeInterface) throws PersistenceException {
        return super.alterar(configuracoesDeInterface);
    }

    @Override
    public boolean remover(ConfiguracoesDeInterface configuracoesDeInterface) throws PersistenceException {
        return super.remover(configuracoesDeInterface);
    }

    private ConfiguracoesDeInterface fillFKedDTOs(ConfiguracoesDeInterface configuracoesDeInterface) throws PersistenceException {
        IUsuarioDAO usuarioDAO = getUsuarioDao();

        Usuario usuario = usuarioDAO.consultarPorId(configuracoesDeInterface.getId());

        configuracoesDeInterface.setUsuario(usuario);

        return configuracoesDeInterface;
    }

    private List<ConfiguracoesDeInterface> fillFKedDTOs(List<ConfiguracoesDeInterface> listConfiguracoesDeInterface) throws PersistenceException {
        for (ConfiguracoesDeInterface configuracoesDeInterface : listConfiguracoesDeInterface)
            fillFKedDTOs(configuracoesDeInterface);
        return listConfiguracoesDeInterface;
    }

    @Override
    public List<ConfiguracoesDeInterface> listar() throws PersistenceException {
        return fillFKedDTOs((List<ConfiguracoesDeInterface>) super.listar());
    }

    @Override
    public List<ConfiguracoesDeInterface> listar(DTO... related) throws PersistenceException {
        return fillFKedDTOs((List<ConfiguracoesDeInterface>) super.listar(related));
    }

    @Override
    public ConfiguracoesDeInterface consultarPorId(Long id) throws PersistenceException {
        return fillFKedDTOs((ConfiguracoesDeInterface) super.consultarPorId(id));
    }

    @Override
    public ConfiguracoesDeInterface consultarPor(DTO... related) throws PersistenceException {
        return fillFKedDTOs((ConfiguracoesDeInterface) super.consultarPor(related));
    }
}
