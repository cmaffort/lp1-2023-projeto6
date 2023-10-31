package br.cefetmg.lagos.model.dao.loja;

import java.util.List;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.ConfiguracoesDeVenda;

public interface IConfiguracoesDeVendaDAO extends IDAO {
    Long inserir(ConfiguracoesDeVenda configuracoesDeVenda) throws PersistenceException;
    
    boolean alterar(ConfiguracoesDeVenda configuracoesDeVenda) throws PersistenceException;
    
    boolean remover(ConfiguracoesDeVenda configuracoesDeVenda) throws PersistenceException;
    
    List<ConfiguracoesDeVenda> listar() throws PersistenceException;

    ConfiguracoesDeVenda cosultarPorId(Long id) throws PersistenceException;
}
