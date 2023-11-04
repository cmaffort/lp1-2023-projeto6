package br.cefetmg.lagos.model.service;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.loja.CaixaDAO;
import br.cefetmg.lagos.model.dao.loja.ICaixaDAO;
import br.cefetmg.lagos.model.dto.loja.Caixa;

import java.util.List;

public class GerirCaixa implements IGerirCaixa {

    private ICaixaDAO caixaDAO;
    
    //acrescentar tratamento de exceções.
    
    public GerirCaixa() {
        
        caixaDAO = new CaixaDAO();
        
    }
    
    @Override
    public long cadastrar(Caixa caixa) throws PersistenceException {
        
        Long result = caixaDAO.inserir(caixa);
        return result;
        
    }

    @Override
    public boolean alterar(Caixa caixa) throws PersistenceException {
        
        boolean result = caixaDAO.alterar(caixa);
        return result;
    
    }

    @Override
    public boolean remover(Caixa caixa) throws PersistenceException {
        
        boolean result = caixaDAO.remover(caixa);
        return result;
        
    }

    @Override
    public List<Caixa> listar() throws PersistenceException {
    
        List<Caixa> result = caixaDAO.listar();
        return result;
        
    }
    
    @Override
    public boolean abrirCaixa(Caixa caixa) throws PersistenceException {
       
        caixa.setAberto(true);
        
        Boolean result = caixaDAO.alterar(caixa);
        
        return result;
       
    }
    
    @Override
    public boolean fecharCaixa(Caixa caixa) throws PersistenceException {
       
        caixa.setAberto(false);
        
        Boolean result = caixaDAO.alterar(caixa);
        
        return result;
       
    }
    
    @Override
    public boolean moverDinheiro(Caixa origem, Caixa destino, Double qtd) throws PersistenceException {
        
        Boolean result = false;
        Boolean[] results = new Boolean[]{false, false};
        
        Double dinheiroOrigem = origem.getDinheiroEmCaixa();
        Double dinheiroDestino = destino.getDinheiroEmCaixa();
        
        
        if(dinheiroDestino>=qtd) {
            
            destino.setDinheiroEmCaixa(dinheiroDestino-qtd);
            origem.setDinheiroEmCaixa(dinheiroOrigem+qtd);
            
            results[0] = caixaDAO.alterar(origem);
            results[1] = caixaDAO.alterar(destino);
            
            result = results[0] && results[1];
            
        }
        
        return result;
        
    }
    
    @Override
    public boolean moverDinheiro(Caixa origem, Double qtd) throws PersistenceException {
        
        Boolean result;
        
        Double dinheiroOrigem = origem.getDinheiroEmCaixa() + qtd;
        
        origem.setDinheiroEmCaixa(dinheiroOrigem);
        
        result = caixaDAO.alterar(origem);
        
        return result;
        
    }
    
}
