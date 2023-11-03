package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.ConfiguracoesDeInterface;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.contrato.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ConfiguracoesDeInterfaceDAO extends AbstractDAO<ConfiguracoesDeInterface> implements IConfiguracoesDeInterfaceDAO {
    private static final IUsuarioDAO USUARIO_DAO;

    static {
        USUARIO_DAO = new UsuarioDAO();
    }

    @Override
    protected ConfiguracoesDeInterface getDTO() {
        return new ConfiguracoesDeInterface();
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementInserir() {
        return List.of(
                new ArrayList<>(getDTO().getManeger().getColumns())
        );
    }

    @Override
    public Long inserir(ConfiguracoesDeInterface configuracoesDeInterface) throws PersistenceException {
        super.inserir(configuracoesDeInterface);
        return configuracoesDeInterface.getId();
    }

    @Override
    protected Map<String, IDAO> getDAOs() {
        return Map.ofEntries(
                Map.entry("usuario", USUARIO_DAO)
        );
    }
}
