package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.PromocoesVendas;

import java.util.List;

public class PromocoesVendasDAO extends AbstractDAO<PromocoesVendas> implements IPromocoesVendasDAO {
    @Override
    protected PromocoesVendas getDTO() {
        return new PromocoesVendas();
    }
}
