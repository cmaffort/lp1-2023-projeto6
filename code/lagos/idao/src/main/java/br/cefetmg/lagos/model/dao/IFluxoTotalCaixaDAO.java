package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.FluxoTotalDeCaixa;

public interface IFluxoTotalCaixaDAO{
    
    boolean inserir(FluxoTotalDeCaixa fluxoTotal) throws SQLException, ClassNotFoundException;    

    boolean alterar(FluxoTotalDeCaixa fluxoTotal) throws SQLException, ClassNotFoundException;
    
    boolean remover(FluxoTotalDeCaixa fluxoTotal) throws SQLException, ClassNotFoundException;
    
    List<FluxoTotalDeCaixa> listar() throws SQLException, ClassNotFoundException;
}
