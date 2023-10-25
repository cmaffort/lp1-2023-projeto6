package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.Cartao;
import br.cefetmg.lagos.model.dto.Endereco;

public interface ICartaoDAO{
    
    boolean inserir(Cartao cartao) throws SQLException, ClassNotFoundException;
    
    boolean alterar(Cartao cartao) throws SQLException, ClassNotFoundException;
    
    boolean remover(Cartao cartao) throws SQLException, ClassNotFoundException;
    
    List<Cartao> listar() throws SQLException, ClassNotFoundException;

    Cartao cosultarPorId(Long id) throws PersistenceException;
}
