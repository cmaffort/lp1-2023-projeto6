package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dto.tipos.Bandeira;
import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Cartao;

public interface ICartaoDAO{
    
    boolean inserir(Cartao cartao) throws SQLException, ClassNotFoundException;
    
    boolean alterar(Cartao cartao) throws SQLException, ClassNotFoundException;
    
    boolean remover(Cartao cartao) throws SQLException, ClassNotFoundException;
    
    List<Cartao> listar() throws SQLException, ClassNotFoundException;
}
