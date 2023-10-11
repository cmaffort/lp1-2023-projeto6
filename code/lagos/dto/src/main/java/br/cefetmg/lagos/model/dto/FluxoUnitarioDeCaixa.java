package br.cefetmg.lagos.model.dto;

import java.util.Date;

public class FluxoUnitarioDeCaixa implements DTO {
    private Double dinheiro;
    private Date hora;
    private Loja loja;

    private Long id;

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
