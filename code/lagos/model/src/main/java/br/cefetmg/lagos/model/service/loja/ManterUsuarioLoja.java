package br.cefetmg.lagos.model.service.loja;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.loja.IUsuarioLojaDAO;
import br.cefetmg.lagos.model.dao.loja.UsuarioLojaDAO;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.loja.Funcionario;
import br.cefetmg.lagos.model.dto.loja.Produto;
import br.cefetmg.lagos.model.dto.loja.PromocoesProdutos;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;
import br.cefetmg.lagos.model.exception.NegocioException;
import br.cefetmg.lagos.model.service.loja.base.AbstractManterLojaModule;

import java.util.List;

public class ManterUsuarioLoja extends AbstractManterLojaModule<UsuarioLoja> implements IManterUsuarioLoja {
    @Override
    protected IUsuarioLojaDAO getDAO() {
        return new UsuarioLojaDAO();
    }

    @Override
    protected UsuarioLoja getDTOInstance() {
        return new UsuarioLoja();
    }

    @Override
    protected List<UsuarioLoja> pesquisarPorLojaNotRelated(Loja loja) throws PersistenceException, NegocioException {
        try {
            return pesquisarPorQualquerDosRelacionados((new ManterFuncionario()).pesquisarPorLoja(loja).toArray(new Funcionario[0]));
        } catch (NegocioException negocioException) {
            return List.of();
        }
    }
}
