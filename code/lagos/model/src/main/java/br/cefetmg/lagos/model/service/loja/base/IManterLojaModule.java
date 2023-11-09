package br.cefetmg.lagos.model.service.loja.base;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.base.IManter;

import java.util.List;

public interface IManterLojaModule<DataTransferObject extends DTO<DataTransferObject>> extends IManter<DataTransferObject> {
    List<DataTransferObject> pesquisarPorLoja(Loja loja) throws NegocioException, PersistenceException;
}
