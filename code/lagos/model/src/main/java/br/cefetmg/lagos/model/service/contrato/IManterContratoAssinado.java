package br.cefetmg.lagos.model.service.contrato;

import br.cefetmg.lagos.model.service.base.IManter;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.exception.NegocioException;

import java.util.List;

public interface IManterContratoAssinado extends IManter<ContratoAssinado> {
    List<ContratoAssinado> pesquisarPorContratante(Usuario usuario) throws NegocioException, PersistenceException;

    List<ContratoAssinado> pesquisarPorContrato(Contrato contrato) throws NegocioException, PersistenceException;

    ContratoAssinado pesquisarContratoAssinadoPorContratante(Usuario usuario) throws NegocioException, PersistenceException;
}
