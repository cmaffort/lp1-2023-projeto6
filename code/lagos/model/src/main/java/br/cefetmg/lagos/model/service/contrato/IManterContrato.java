package br.cefetmg.lagos.model.service.contrato;

import br.cefetmg.lagos.model.base.IManter;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Contrato;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.exception.NegocioException;

import java.util.List;

public interface IManterContrato extends IManter<Contrato> {
    List<Contrato> pesquisarPorContratante(Usuario usuario) throws NegocioException, PersistenceException;
}
