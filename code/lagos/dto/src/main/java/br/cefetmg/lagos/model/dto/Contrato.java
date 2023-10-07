package br.cefetmg.lagos.model.dto;

import java.io.File;
import java.util.Date;
import java.util.List;

public class Contrato implements DTO {
    private boolean vigente;
    private Date dataDeContratacao;
    private Date dataDeValidade;
    private String descricao;
    private double preco;
    private List<File> documentos;
    private float taxaDeMulta;
    private double ativo;

    private Usuario contratante;
    private Periodicidade periodicidade;

    private long id;

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public Date getDataDeContratacao() {
        return dataDeContratacao;
    }

    public void setDataDeContratacao(Date dataDeContratacao) {
        this.dataDeContratacao = dataDeContratacao;
    }

    public Date getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(Date dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<File> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<File> documentos) {
        this.documentos = documentos;
    }

    public float getTaxaDeMulta() {
        return taxaDeMulta;
    }

    public void setTaxaDeMulta(float taxaDeMulta) {
        this.taxaDeMulta = taxaDeMulta;
    }

    public double getAtivo() {
        return ativo;
    }

    public void setAtivo(double ativo) {
        this.ativo = ativo;
    }

    public Usuario getContratante() {
        return contratante;
    }

    public void setContratante(Usuario contratante) {
        this.contratante = contratante;
    }

    public Periodicidade getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(Periodicidade periodicidade) {
        this.periodicidade = periodicidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
