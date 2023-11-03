package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.Venda;

public interface IVendaDAO extends IDAO<Venda> {
    Double sum() throws PersistenceException;

    Double sum(DTO... related) throws PersistenceException;
}
