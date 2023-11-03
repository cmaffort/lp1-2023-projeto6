package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.ConfiguracoesDeVenda;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.List;

public class ConfiguracoesDeVendaDAO extends AbstractDAO<ConfiguracoesDeVenda> implements IConfiguracoesDeVendaDAO {
    @Override
    protected ConfiguracoesDeVenda getDTO() {
        return new ConfiguracoesDeVenda();
    }
}
