package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.PromocoesVendas;

import java.util.List;

public interface IPromocoesVendasDAO extends IDAO {
    Long inserir(PromocoesVendas promocoesVendas) throws PersistenceException;

    boolean alterar(PromocoesVendas promocoesVendas) throws PersistenceException;

    boolean remover(PromocoesVendas promocoesVendas) throws PersistenceException;

    List<PromocoesVendas> listar() throws PersistenceException;

    List<PromocoesVendas> listar(DTO... related) throws PersistenceException;

    PromocoesVendas consultarPorId(Long id) throws PersistenceException;
}
