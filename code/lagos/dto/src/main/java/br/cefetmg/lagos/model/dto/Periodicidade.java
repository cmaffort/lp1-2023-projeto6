package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

@Table(nome = "periodicidade")
public class Periodicidade extends AbstractDTO implements DTO {
    private int periodo;
    private int quantidadeDiasPorPeriodo;

    private long id;

    @Column(nome = "periodo")
    @Getter
    public int getPeriodo() {
        return periodo;
    }

    @Column(nome = "periodo")
    @Setter
    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    @Column(nome = "quantidade_dias_por_periodo")
    @Getter
    public int getQuantidadeDiasPorPeriodo() {
        return quantidadeDiasPorPeriodo;
    }

    @Column(nome = "quantidade_dias_por_periodo")
    @Setter
    public void setQuantidadeDiasPorPeriodo(int quantidadeDiasPorPeriodo) {
        this.quantidadeDiasPorPeriodo = quantidadeDiasPorPeriodo;
    }

    @Column(nome = "pk")
    @Getter
    public long getId() {
        return id;
    }

    @Column(nome = "pk")
    @Setter
    public void setId(long id) {
        this.id = id;
    }
}
