package br.cefetmg.lagos.model.dto;

import java.util.Date;

public class ContratoAssinado implements DTO {
    private Boolean vigente;
    private Date dataDeContratacao;
    private Boolean cancelado;

    private Contratante contratante;
    private Contrato contrato;

    private Long id;

    public Boolean isVigente() {
        return vigente;
    }

    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }

    public Date getDataDeContratacao() {
        return dataDeContratacao;
    }

    public void setDataDeContratacao(Date dataDeContratacao) {
        this.dataDeContratacao = dataDeContratacao;
    }

    public Boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(Boolean cancelado) {
        this.cancelado = cancelado;
    }

    public Contratante getContratante() {
        return contratante;
    }

    public void setContratante(Contratante contratante) {
        this.contratante = contratante;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
