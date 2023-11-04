package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.dto.contrato.Usuario;

import java.util.List;

public interface IContratoDAO extends IDAO<Contrato> {
    List<Contrato> filtrarRelated(Usuario usuario) throws PersistenceException;
}
