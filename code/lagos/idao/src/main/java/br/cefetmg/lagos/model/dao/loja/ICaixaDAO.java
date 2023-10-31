package br.cefetmg.lagos.model.dao.loja;

import java.util.List;

import br.cefetmg.lagos.model.dao.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.Caixa;

public interface ICaixaDAO extends IDAO {
    Long inserir(Caixa caixa) throws PersistenceException;

    boolean alterar(Caixa caixa) throws PersistenceException;
    
    boolean remover(Caixa caixa) throws PersistenceException;
    
    List<Caixa> listar() throws PersistenceException;

    Caixa consultarPorId(Long id) throws PersistenceException;

    Caixa consultarPor(DTO... related) throws PersistenceException;
}
