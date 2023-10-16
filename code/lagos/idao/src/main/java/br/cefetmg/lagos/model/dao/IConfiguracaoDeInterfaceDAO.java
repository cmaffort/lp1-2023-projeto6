package br.cefetmg.lagos.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.cefetmg.lagos.model.dto.ConfiguracoesDeInterface;

public interface IConfiguracaoDeInterfaceDAO{
    
    boolean inserir(ConfiguracoesDeInterface configuracaoInterface) throws SQLException, ClassNotFoundException;
    
    boolean alterar(ConfiguracoesDeInterface configuracaoInterface) throws SQLException, ClassNotFoundException;
    
    boolean remover(ConfiguracoesDeInterface configuracaoInterface) throws SQLException, ClassNotFoundException;
    
    List<ConfiguracoesDeInterface> listar() throws SQLException, ClassNotFoundException;
}
