package br.cefetmg.lagos.model.service;

import br.cefetmg.lagos.model.dto.Caixa;
import br.cefetmg.lagos.model.dao.ICaixaDAO;
import br.cefetmg.lagos.model.dao.CaixaDAO;
import java.sql.SQLException;
import java.util.List;

public class GerirCaixa implements IGerirCaixa {

    private ICaixaDAO caixaDAO;
    
    //acrescentar tratamento de exceções.
    
    public GerirCaixa() {
        
        caixaDAO = new CaixaDAO();
        
    }
    
    @Override
    public long cadastrar(Caixa caixa) throws SQLException, ClassNotFoundException {
        
        Long result = caixaDAO.inserir(caixa);
        return result;
        
    }

    @Override
    public boolean alterar(Caixa caixa) throws SQLException, ClassNotFoundException {
        
        boolean result = caixaDAO.alterar(caixa);
        return result;
    
    }

    @Override
    public boolean remover(Caixa caixa) throws SQLException, ClassNotFoundException {
        
        boolean result = caixaDAO.remover(caixa);
        return result;
        
    }

    @Override
    public List<Caixa> listar() throws SQLException, ClassNotFoundException {
    
        List<Caixa> result = caixaDAO.listar();
        return result;
        
    }
    
}
