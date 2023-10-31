package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.contrato.ConfiguracoesDeInterface;

import java.util.List;

public interface IConfiguracoesDeInterfaceDAO extends IDAO {
    Long inserir(ConfiguracoesDeInterface configuracoesDeInterface) throws PersistenceException;
    
    boolean alterar(ConfiguracoesDeInterface configuracoesDeInterface) throws PersistenceException;
    
    boolean remover(ConfiguracoesDeInterface configuracoesDeInterface) throws PersistenceException;
    
    List<ConfiguracoesDeInterface> listar() throws PersistenceException;

    ConfiguracoesDeInterface cosultarPorId(Long id) throws PersistenceException;
}
