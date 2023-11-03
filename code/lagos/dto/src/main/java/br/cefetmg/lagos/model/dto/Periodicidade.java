package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

import java.util.List;

@Table(nome = "periodicidade")
public class Periodicidade extends AbstractDTO<Periodicidade> implements DTO<Periodicidade> {
    private Integer periodo;
    private Integer quantidadeDiasPorPeriodo;

    private Long id;

    @Column(nome = "periodo", tipo = Integer.class)
    @Getter
    public Integer getPeriodo() {
        return periodo;
    }

    @Column(nome = "periodo", tipo = Integer.class)
    @Setter
    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    @Column(nome = "quantidade_dias_por_periodo", tipo = Integer.class)
    @Getter
    public Integer getQuantidadeDiasPorPeriodo() {
        return quantidadeDiasPorPeriodo;
    }

    @Column(nome = "quantidade_dias_por_periodo", tipo = Integer.class)
    @Setter
    public void setQuantidadeDiasPorPeriodo(Integer quantidadeDiasPorPeriodo) {
        this.quantidadeDiasPorPeriodo = quantidadeDiasPorPeriodo;
    }

    @Column(nome = "pk", tipo = Long.class)
    @Getter
    public Long getId() {
        return id;
    }

    @Column(nome = "pk", tipo = Long.class)
    @Setter
    public void setId(Long id) {
        this.id = id;
    }
}
