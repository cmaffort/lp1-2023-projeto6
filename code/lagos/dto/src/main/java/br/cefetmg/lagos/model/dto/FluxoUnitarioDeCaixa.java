package br.cefetmg.lagos.model.dto;

import java.util.Date;

public class FluxoUnitarioDeCaixa implements DTO {
    private double dinheiro;
    private Date hora;
    private Loja loja;

    private long id;

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
