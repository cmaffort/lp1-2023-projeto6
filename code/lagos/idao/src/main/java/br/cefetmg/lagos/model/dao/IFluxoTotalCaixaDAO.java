package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.loja.FluxoDeCaixa;

public interface IFluxoTotalCaixaDAO{
    
    boolean inserir(FluxoDeCaixa fluxoTotal) throws SQLException, ClassNotFoundException;

    boolean alterar(FluxoDeCaixa fluxoTotal) throws SQLException, ClassNotFoundException;
    
    boolean remover(FluxoDeCaixa fluxoTotal) throws SQLException, ClassNotFoundException;
    
    List<FluxoDeCaixa> listar() throws SQLException, ClassNotFoundException;
}
