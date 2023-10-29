package br.cefetmg.lagos.model.dto;

import java.util.List;

public class Periodicidade implements DTO {
    private Integer periodo;
    private Integer qtdDiasPorPeriodo;

    private long id;

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Integer getQtdDiasPorPeriodo() {
        return qtdDiasPorPeriodo;
    }

    public void setQtdDiasPorPeriodo(Integer qtdDiasPorPeriodo) {
        this.qtdDiasPorPeriodo = qtdDiasPorPeriodo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
