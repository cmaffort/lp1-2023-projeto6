package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.GerenteDeContrato;

public interface IGerenteDeContratoDAO {
    
    boolean inserir(GerenteDeContrato gerenteContrato) throws SQLException, ClassNotFoundException;
    
    boolean alterar(GerenteDeContrato gerenteContrato) throws SQLException, ClassNotFoundException;
    
    boolean remover(GerenteDeContrato gerenteContrato) throws SQLException, ClassNotFoundException;
    
    List<GerenteDeContrato> listar() throws SQLException, ClassNotFoundException;
}
