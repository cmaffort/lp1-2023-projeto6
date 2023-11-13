package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.contrato.Usuario;

public interface ILojaDAO extends IDAO<Loja> {
    long countLojas(Usuario usuario) throws PersistenceException;
}
