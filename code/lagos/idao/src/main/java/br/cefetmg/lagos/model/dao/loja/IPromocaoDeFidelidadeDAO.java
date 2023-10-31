package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.PromocaoDeFidelidade;

import java.util.List;

public interface IPromocaoDeFidelidadeDAO extends IDAO {
    Long inserir(PromocaoDeFidelidade promocaoDeFidelidade) throws PersistenceException;
    
    boolean alterar(PromocaoDeFidelidade promocaoDeFidelidade) throws PersistenceException;
    
    boolean remover(PromocaoDeFidelidade promocaoDeFidelidade) throws PersistenceException;
    
    List<PromocaoDeFidelidade> listar() throws PersistenceException;

    PromocaoDeFidelidade consultarPorId(Long id) throws PersistenceException;
}
