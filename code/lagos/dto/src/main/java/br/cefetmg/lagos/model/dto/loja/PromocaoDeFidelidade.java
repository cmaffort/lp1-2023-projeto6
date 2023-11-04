package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.Periodicidade;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.sql.Date;

@Table(nome = "promocao_de_fidelidade")
@PrimaryKey(nome = "pk")
public class PromocaoDeFidelidade extends AbstractDTO<PromocaoDeFidelidade> implements DTO<PromocaoDeFidelidade> {
    private Integer minVendas;
    private Boolean ativa;
    private Float porcentagem;
    private Date dataInicio;

    private Periodicidade periodicidade;
    private Loja loja;

    private Long id;

    @Column(nome = "min_vendas", tipo = Integer.class)
    @NotNull
    @Getter
    public Integer getMinVendas() {
        return minVendas;
    }

    @Column(nome = "min_vendas", tipo = Integer.class)
    @NotNull
    @Setter
    public void setMinVendas(Integer minVendas) {
        this.minVendas = minVendas;
    }

    @Column(nome = "ativa", tipo = Boolean.class)
    @NotNull
    @Getter
    public Boolean isAtiva() {
        return ativa;
    }

    @Column(nome = "ativa", tipo = Boolean.class)
    @NotNull
    @Setter
    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    @Column(nome = "porcentagem", tipo = Float.class)
    @NotNull
    @Getter
    public Float getPorcentagem() {
        return porcentagem;
    }

    @Column(nome = "porcentagem", tipo = Float.class)
    @NotNull
    @Setter
    public void setPorcentagem(Float porcentagem) {
        this.porcentagem = porcentagem;
    }

    @Column(nome = "data_inicio", tipo = Date.class)
    @NotNull
    @Getter
    public Date getDataInicio() {
        return dataInicio;
    }

    @Column(nome = "data_inicio", tipo = Date.class)
    @NotNull
    @Setter
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Related(nome = "periodicidade")
    @Getter
    public Periodicidade getPeriodicidade() {
        return periodicidade;
    }

    @Related(nome = "periodicidade")
    @Setter
    public void setPeriodicidade(Periodicidade periodicidade) {
        this.periodicidade = periodicidade;
    }

    @Column(nome = "periodicidade__fk", tipo = Long.class)
    @NotNull
    @Getter
    public Long getPeriodicidadeAsLong() {
        return getRelatedAsLong(getPeriodicidade());
    }

    @Column(nome = "periodicidade__fk", tipo = Long.class)
    @NotNull
    @Setter
    public void setPeriodicidadeWithLong(Long id) {
        setPeriodicidade(setRelatedWithLong(getPeriodicidade(), id, new Periodicidade()));
    }

    @Related(nome = "loja")
    @Getter
    public Loja getLoja() {
        return loja;
    }

    @Related(nome = "loja")
    @Setter
    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    @Column(nome = "loja__fk", tipo = Long.class)
    @NotNull
    @Getter
    public Long getLojaAsLong() {
        return getRelatedAsLong(getLoja());
    }

    @Column(nome = "loja__fk", tipo = Long.class)
    @NotNull
    @Setter
    public void setLojaWithLong(Long id) {
        setLoja(setRelatedWithLong(getLoja(), id, new Loja()));
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
