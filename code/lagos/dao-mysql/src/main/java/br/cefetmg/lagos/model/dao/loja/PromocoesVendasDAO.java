package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dto.loja.PromocoesVendas;

public class PromocoesVendasDAO extends AbstractDAO<PromocoesVendas> implements IPromocoesVendasDAO {
    @Override
    protected PromocoesVendas getDTO() {
        return new PromocoesVendas();
    }
}
