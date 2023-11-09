package br.cefetmg.lagos.model.service.loja.old;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.loja.Caixa;

import java.util.List;

public interface IManterCaixa {

    Long cadastrar(Caixa caixa) throws PersistenceException;

    boolean alterar(Caixa caixa) throws PersistenceException;

    boolean excluir(Caixa caixa) throws PersistenceException;

    List<Caixa> pesquisarTodos() throws PersistenceException;

    boolean abrirCaixa(Caixa caixa) throws PersistenceException;

    boolean fecharCaixa(Caixa caixa) throws PersistenceException;

    boolean moverDinheiro(Caixa origem, Caixa destino, Double qtd) throws PersistenceException;

    boolean moverDinheiro(Caixa origem, Double qtd) throws PersistenceException;

}
