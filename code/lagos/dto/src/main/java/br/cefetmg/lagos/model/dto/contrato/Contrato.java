package br.cefetmg.lagos.model.dto.contrato;

import br.cefetmg.lagos.model.dto.Periodicidade;
import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

import java.sql.Date;

@Table(nome = "contrato")
@PrimaryKey(nome = "pk")
public class Contrato extends AbstractDTO<Contrato> implements DTO<Contrato> {
    private Boolean ativo;
    private String descricao;
    private Double preco;
    private byte[] documento;
    private Float taxaDeMulta;
    private Integer numeroDeLojas;
    private Date dataDeCriacao;
    private Periodicidade periodicidade;
    private Long id;

    @Column(nome = "ativo", tipo = Boolean.class)
    @NotNull
    @Getter
    public Boolean isAtivo() {
        return ativo;
    }

    @Column(nome = "ativo", tipo = Boolean.class)
    @NotNull
    @Setter
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Column(nome = "descricao", tipo = String.class)
    @Getter
    public String getDescricao() {
        return descricao;
    }

    @Column(nome = "descricao", tipo = String.class)
    @Setter
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(nome = "preco", tipo = Double.class)
    @NotNull
    @Getter
    public Double getPreco() {
        return preco;
    }

    @Column(nome = "preco", tipo = Double.class)
    @NotNull
    @Setter
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Column(nome = "documento", tipo = byte[].class)
    @Getter
    public byte[] getDocumento() {
        return documento;
    }

    @Column(nome = "documento", tipo = byte[].class)
    @Setter
    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }

    @Column(nome = "taxa_de_multa", tipo = Float.class)
    @Getter
    public Float getTaxaDeMulta() {
        return taxaDeMulta;
    }

    @Column(nome = "taxa_de_multa", tipo = Float.class)
    @Setter
    public void setTaxaDeMulta(Float taxaDeMulta) {
        this.taxaDeMulta = taxaDeMulta;
    }

    @Column(nome = "numero_de_lojas", tipo = Integer.class)
    @NotNull
    @Getter
    public Integer getNumeroDeLojas() {
        return numeroDeLojas;
    }

    @Column(nome = "numero_de_lojas", tipo = Integer.class)
    @NotNull
    @Setter
    public void setNumeroDeLojas(Integer numeroDeLojas) {
        this.numeroDeLojas = numeroDeLojas;
    }

    @Column(nome = "data_de_criacao", tipo = Date.class)
    @NotNull
    @Getter
    public Date getDataDeCriacao() {
        return dataDeCriacao;
    }

    @Column(nome = "data_de_criacao", tipo = Date.class)
    @NotNull
    @Setter
    public void setDataDeCriacao(Date dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
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
        return getRelatedAsLong(periodicidade);
    }

    @Column(nome = "periodicidade__fk", tipo = Long.class)
    @NotNull
    @Setter
    public void setPeriodicidadeWithLong(Long id) {
        periodicidade = setRelatedWithLong(periodicidade, id, new Periodicidade());
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
