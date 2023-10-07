package br.cefetmg.lagos.model.dto;

public class Caixa implements DTO {
    private boolean estaAberto;
    private double dinheiroEmCaixa;

    private Usuario caixeiro;
    private FluxoTotalDeCaixa fluxoTotalDeCaixa;
    private Loja loja;

    private long id;

    public boolean estaAberto() {
        return estaAberto;
    }

    public void setEstaAberto(boolean estaAberto) {
        this.estaAberto = estaAberto;
    }

    public double getDinheiroEmCaixa() {
        return dinheiroEmCaixa;
    }

    public void setDinheiroEmCaixa(double dinheiroEmCaixa) {
        this.dinheiroEmCaixa = dinheiroEmCaixa;
    }

    public Usuario getCaixeiro() {
        return caixeiro;
    }

    public void setCaixeiro(Usuario caixeiro) {
        this.caixeiro = caixeiro;
    }

    public FluxoTotalDeCaixa getFluxoTotalDeCaixa() {
        return fluxoTotalDeCaixa;
    }

    public void setFluxoTotalDeCaixa(FluxoTotalDeCaixa fluxoTotalDeCaixa) {
        this.fluxoTotalDeCaixa = fluxoTotalDeCaixa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
