package br.cefetmg.lagos.model.service;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.Caixa;

public interface IGerirCaixa {
    
    long cadastrar(Caixa caixa) throws SQLException, ClassNotFoundException;

    boolean alterar(Caixa caixa) throws SQLException, ClassNotFoundException;
    
    boolean remover(Caixa caixa) throws SQLException, ClassNotFoundException;
    
    List<Caixa> listar() throws SQLException, ClassNotFoundException;
    
    boolean abrirCaixa(Caixa caixa) throws SQLException, ClassNotFoundException;
    
    boolean fecharCaixa(Caixa caixa) throws SQLException, ClassNotFoundException;
    
    boolean moverDinheiro(Caixa origem, Caixa destino, Double qtd) throws SQLException, ClassNotFoundException;
    
    boolean moverDinheiro(Caixa origem, Double qtd) throws SQLException, ClassNotFoundException;
    
}