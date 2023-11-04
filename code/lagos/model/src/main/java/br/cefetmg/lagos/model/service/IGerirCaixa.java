package br.cefetmg.lagos.model.service;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.Caixa;

import java.sql.SQLException;
import java.util.List;

public interface IGerirCaixa {
    
    long cadastrar(Caixa caixa) throws PersistenceException;

    boolean alterar(Caixa caixa) throws PersistenceException;
    
    boolean remover(Caixa caixa) throws PersistenceException;
    
    List<Caixa> listar() throws PersistenceException;
    
    boolean abrirCaixa(Caixa caixa) throws PersistenceException;
    
    boolean fecharCaixa(Caixa caixa) throws PersistenceException;
    
    boolean moverDinheiro(Caixa origem, Caixa destino, Double qtd) throws PersistenceException;
    
    boolean moverDinheiro(Caixa origem, Double qtd) throws PersistenceException;
    
}
