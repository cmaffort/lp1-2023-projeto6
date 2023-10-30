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
    
    @Override
    public boolean abrirCaixa(Caixa caixa) throws SQLException, ClassNotFoundException {
       
        caixa.setAberto(true);
        
        Boolean result = caixaDAO.alterar(caixa);
        
        return result;
       
    }
    
    @Override
    public boolean fecharCaixa(Caixa caixa) throws SQLException, ClassNotFoundException {
       
        caixa.setAberto(false);
        
        Boolean result = caixaDAO.alterar(caixa);
        
        return result;
       
    }
    
    @Override
    public boolean moverDinheiro(Caixa origem, Caixa destino, Double qtd) throws SQLException, ClassNotFoundException {
        
        Boolean result = false;
        Boolean[] results = new Boolean[]{false, false};
        
        Double dinheiroOrigem = origem.getDinheiroEmCaixa();
        Double dinheiroDestino = destino.getDinheiroEmCaixa();
        
        
        if(dinheiroDestino>=qtd) {
            
            destino.setDinheiroEmCaixa(dinheiroDestino-qtd);
            origem.setDinheiroEmCaixa(dinheiroOrigem+qtd);
            
            results[0] = caixaDAO.alterar(origem);
            results[1] = caixaDAO.alterar(destino);
            
            result = results[0]&&results[1]&&true;
            
        }
        
        return result;
        
    }
    
    @Override
    public boolean moverDinheiro(Caixa origem, Double qtd) throws SQLException, ClassNotFoundException {
        
        Boolean result;
        
        Double dinheiroOrigem = origem.getDinheiroEmCaixa()+qtd;
        
        origem.setDinheiroEmCaixa(dinheiroOrigem);
        
        result = caixaDAO.alterar(origem);
        
        return result;
        
    }
    
}
