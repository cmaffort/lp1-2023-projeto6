package br.cefetmg.lagos.model.dto;

import javax.swing.plaf.FontUIResource;
import java.util.Date;

public class FluxoUnitarioDeCaixa implements DTO {
    private Double dinheiro;
    private Date hora;

    private FluxoTotalDeCaixa fluxoTotalDeCaixa;
    private Loja loja;

    private long id;

    public Double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
