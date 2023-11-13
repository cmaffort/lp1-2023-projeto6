package br.cefetmg.lagos.model.service.loja.base;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.base.AbstractManter;

import java.util.List;

public abstract class AbstractManterLojaModule<DataTransferObject extends DTO<DataTransferObject>> extends AbstractManter<DataTransferObject>
        implements IManterLojaModule<DataTransferObject> {
    protected List<DataTransferObject> pesquisarPorLojaNotRelated(Loja loja) throws PersistenceException, NegocioException {
        throw new PersistenceException("O campo não é relacionado com loja");
    }

    public List<DataTransferObject> pesquisarPorLoja(Loja loja) throws NegocioException, PersistenceException {
        assertIdIsNotNull(loja.getId());
        try {
            return pesquisarPorRelacionado(loja);
        } catch (NegocioException negocioException) {
            return pesquisarPorLojaNotRelated(loja);
        }
    }
}
