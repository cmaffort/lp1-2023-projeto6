package br.cefetmg.lagos.model.dto;

import java.io.File;
import java.util.Date;
import java.util.List;

public class Contrato implements DTO {
    private Boolean ativo;
    private String descricao;
    private Double preco;
    private List<File> documentos;
    private Float taxaDeMulta;
    private Integer numeroDeLojas;
    private Date dataDeCriacao;

    private List<ContratoAssinado> contratosAssinados;
    private Periodicidade periodicidade;

    private Long id;

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<File> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<File> documentos) {
        this.documentos = documentos;
    }

    public Float getTaxaDeMulta() {
        return taxaDeMulta;
    }

    public void setTaxaDeMulta(Float taxaDeMulta) {
        this.taxaDeMulta = taxaDeMulta;
    }

    public Integer getNumeroDeLojas() {
        return numeroDeLojas;
    }

    public void setNumeroDeLojas(Integer numeroDeLojas) {
        this.numeroDeLojas = numeroDeLojas;
    }

    public Date getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(Date dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public List<ContratoAssinado> getContratosAssinados() {
        return contratosAssinados;
    }

    public void setContratosAssinados(List<ContratoAssinado> contratosAssinados) {
        this.contratosAssinados = contratosAssinados;
    }

    public Periodicidade getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(Periodicidade periodicidade) {
        this.periodicidade = periodicidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
