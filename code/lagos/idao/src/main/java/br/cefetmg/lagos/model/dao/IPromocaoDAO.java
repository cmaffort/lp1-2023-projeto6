package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Promocao;

public interface IPromocaoDAO {
    
    boolean inserir(Promocao promocao) throws SQLException, ClassNotFoundException;
    
    boolean alterar(Promocao promocao) throws SQLException, ClassNotFoundException;
    
    boolean remover(Promocao promocao) throws SQLException, ClassNotFoundException;
    
    List<Promocao> listar() throws SQLException, ClassNotFoundException;
}
