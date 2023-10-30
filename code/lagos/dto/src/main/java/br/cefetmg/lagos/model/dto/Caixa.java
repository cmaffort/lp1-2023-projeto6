package br.cefetmg.lagos.model.dto;

import java.util.List;

public class Caixa implements DTO {
    
    private Boolean aberto;
    private Double dinheiroEmCaixa;
    private String caixeiro;
    private Double fluxoTotalDeCaixa;
    private Long loja;
    private Long id;

    public Boolean isAberto() {
        return aberto;
    }

    public void setAberto(Boolean aberto) {
        this.aberto = aberto;
    }

    public Double getDinheiroEmCaixa() {
        return dinheiroEmCaixa;
    }

    public void setDinheiroEmCaixa(Double dinheiroEmCaixa) {
        this.dinheiroEmCaixa = dinheiroEmCaixa;
    }

    public String getCaixeiro() {
        return caixeiro;
    }

    public void setCaixeiro(Caixeiro caixeiro) {
        this.caixeiro = caixeiro.getNome();
    }

    public void setCaixeiro(String caixeiroNome) {
        this.caixeiro = caixeiroNome;
    }
    
    public Double getFluxoTotalDeCaixa() {
        return fluxoTotalDeCaixa;
    }

    public void setFluxoTotalDeCaixa(FluxoTotalDeCaixa fluxoTotalDeCaixa) {
        
        List<FluxoUnitarioDeCaixa> fluxos;
        double result = 0;
        
        fluxos = fluxoTotalDeCaixa.getFluxosUnitarioDeCaixa();
        
        for (FluxoUnitarioDeCaixa f : fluxos)
            result += f.getDinheiro();
       
        this.fluxoTotalDeCaixa = result;
        
    }
    
    public void setFluxoTotalDeCaixa(Double fluxoTotal) {
       
        this.fluxoTotalDeCaixa = fluxoTotal;
       
    }

    public Long getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja.getEndereco().getCep();
    }
    public void setLoja(Long lojaCEP) {
        this.loja = lojaCEP;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
