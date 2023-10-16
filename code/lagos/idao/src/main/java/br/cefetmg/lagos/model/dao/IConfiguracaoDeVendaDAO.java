package br.cefetmg.lagos.model.dao;

import br.cefetmg.lagos.model.dto.tipos.MetodosPagamento;
import br.cefetmg.lagos.model.dto.tipos.Bandeira;
import java.util.List;
import java.sql.SQLException;
import br.cefetmg.lagos.model.dto.ConfiguracoesDeVenda;

public interface IConfiguracaoDeVendaDAO{
    
    boolean inserir(ConfiguracoesDeVenda configuracaoVenda) throws SQLException, ClassNotFoundException;
    
    boolean alterar(ConfiguracoesDeVenda configuracaoVenda) throws SQLException, ClassNotFoundException;
    
    boolean remover(ConfiguracoesDeVenda configuracaoVenda) throws SQLException, ClassNotFoundException;
    
    List<ConfiguracoesDeVenda> listar() throws SQLException, ClassNotFoundException;
}
