package br.cefetmg.lagos.model.dto.contrato;

import br.cefetmg.lagos.model.dto.Periodicidade;
import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

@Table(nome = "contrato")
public class Contrato extends AbstractDTO implements DTO {
    private boolean ativo;
    private String descricao;
    private double preco;
    private List<Blob> documentos;
    private float taxaDeMulta;
    private int numeroDeLojas;
    private Date dataDeCriacao;

    private Periodicidade periodicidade;

    private List<ContratoAssinado> contratosAssinados;

    private long id;

    @Column(nome = "ativo")
    @Getter
    public boolean isAtivo() {
        return ativo;
    }

    @Column(nome = "ativo")
    @Setter
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Column(nome = "descricao")
    @Getter
    public String getDescricao() {
        return descricao;
    }

    @Column(nome = "descricao")
    @Setter
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(nome = "preco")
    @Getter
    public double getPreco() {
        return preco;
    }

    @Column(nome = "preco")
    @Setter
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<Blob> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Blob> documentos) {
        this.documentos = documentos;
    }

    // TODO: Get e Set documentos as blob?

    @Column(nome = "documentos")
    @Getter
    public Blob getDocumentosAsBlob() {return null;}

    @Column(nome = "documentos")
    @Setter
    public void setDocumentosWithBlob(Blob documentos) {}

    @Column(nome = "taxa_de_multa")
    @Getter
    public float getTaxaDeMulta() {
        return taxaDeMulta;
    }

    @Column(nome = "taxa_de_multa")
    @Setter
    public void setTaxaDeMulta(float taxaDeMulta) {
        this.taxaDeMulta = taxaDeMulta;
    }

    @Column(nome = "numero_de_lojas")
    @Getter
    public int getNumeroDeLojas() {
        return numeroDeLojas;
    }

    @Column(nome = "numero_de_lojas")
    @Setter
    public void setNumeroDeLojas(int numeroDeLojas) {
        this.numeroDeLojas = numeroDeLojas;
    }

    @Column(nome = "data_de_criacao")
    @Getter
    public Date getDataDeCriacao() {
        return dataDeCriacao;
    }

    @Column(nome = "data_de_criacao")
    @Setter
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
