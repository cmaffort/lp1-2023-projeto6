package br.cefetmg.lagos.model.dto;

public class Caixa implements DTO {
    private Boolean aberto;
    private Double dinheiroEmCaixa;

    private Caixeiro caixeiro;
    private FluxoTotalDeCaixa fluxoTotalDeCaixa;
    private Loja loja;

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

    public Caixeiro getCaixeiro() {
        return caixeiro;
    }

    public void setCaixeiro(Caixeiro caixeiro) {
        this.caixeiro = caixeiro;
    }

    public FluxoTotalDeCaixa getFluxoTotalDeCaixa() {
        return fluxoTotalDeCaixa;
    }

    public void setFluxoTotalDeCaixa(FluxoTotalDeCaixa fluxoTotalDeCaixa) {
        this.fluxoTotalDeCaixa = fluxoTotalDeCaixa;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
