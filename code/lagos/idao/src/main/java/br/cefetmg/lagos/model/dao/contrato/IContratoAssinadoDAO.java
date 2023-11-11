package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.contrato.Usuario;

public interface IContratoAssinadoDAO extends IDAO<ContratoAssinado> {
    ContratoAssinado filterContratoAssinadoAtivo(Usuario usuario) throws PersistenceException;
}
