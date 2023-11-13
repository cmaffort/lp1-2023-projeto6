package br.cefetmg.lagos.model.service.contrato;

import br.cefetmg.lagos.model.service.base.IManter;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.Cartao;
import br.cefetmg.lagos.model.dto.contrato.Usuario;
import br.cefetmg.lagos.model.exception.NegocioException;

import java.util.List;

public interface IManterCartao extends IManter<Cartao> {
    List<Cartao> pesquisarPorContratante(Usuario usuario) throws NegocioException, PersistenceException;
}
