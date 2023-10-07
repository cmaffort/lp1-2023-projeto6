package br.cefetmg.lagos.model.dto;

import java.util.List;

public class Periodicidade implements DTO {
    private int periodo;
    private int qtdDiasPorPeriodo;

    private long id;

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getQtdDiasPorPeriodo() {
        return qtdDiasPorPeriodo;
    }

    public void setQtdDiasPorPeriodo(int qtdDiasPorPeriodo) {
        this.qtdDiasPorPeriodo = qtdDiasPorPeriodo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
