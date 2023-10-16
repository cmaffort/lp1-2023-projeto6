package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.FluxoUnitarioDeCaixa;

public interface IFluxoUnitarioCaixaDAO{
    boolean inserir(FluxoUnitarioDeCaixa fluxoUnitario) throws SQLException, ClassNotFoundException;
    
    boolean alterar(FluxoUnitarioDeCaixa fluxoUnitario) throws SQLException, ClassNotFoundException;
    
    boolean remover(FluxoUnitarioDeCaixa fluxoUnitario) throws SQLException, ClassNotFoundException;
    
    List<FluxoUnitarioDeCaixa> listar() throws SQLException, ClassNotFoundException;
}