package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dto.loja.ConfiguracoesDeVenda;

public class ConfiguracoesDeVendaDAO extends AbstractDAO<ConfiguracoesDeVenda> implements IConfiguracoesDeVendaDAO {
    @Override
    protected ConfiguracoesDeVenda getDTO() {
        return new ConfiguracoesDeVenda();
    }
}
