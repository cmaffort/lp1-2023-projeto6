package br.cefetmg.lagos.model.dto;

import java.util.List;

public class Periodicidade implements DTO {
    private Integer periodo;
    private Integer qtdDiasPorPeriodo;

    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
