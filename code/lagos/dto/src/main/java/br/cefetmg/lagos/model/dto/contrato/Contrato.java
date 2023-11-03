package br.cefetmg.lagos.model.dto.contrato;

import br.cefetmg.lagos.model.dto.Periodicidade;
import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

import java.io.File;
import java.sql.Blob;
import java.sql.Date;

@Table(nome = "contrato")
public class Contrato extends AbstractDTO<Contrato> implements DTO<Contrato> {
    private boolean ativo;
    private String descricao;
    private double preco;
    private File documento;
    private float taxaDeMulta;
    private int numeroDeLojas;
    private Date dataDeCriacao;

    private Periodicidade periodicidade;

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

    // TODO: Implementar parser de File para Blob e de Blob para file

    public File getDocumento() {
        return documento;
    }

    public void setDocumento(File documento) {
        this.documento = documento;
    }

    @Column(nome = "documento")
    @Getter
    public Blob getDocumentoAsBlob() {
        return null;
    }

    @Column(nome = "documento")
    @Setter
    public void setDocumentoWithBlob(Blob documento) {

    }

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

    @Column(nome = "periodicidade__fk")
    @Getter
    public long getPeriodicidadeAsLong() {
        return getRelatedAsLong(getPeriodicidade());
    }

    @Column(nome = "periodicidade__fk")
    @Setter
    public void setPeriodicidadeWithLong(long id) {
        setPeriodicidade(setRelatedWithLong(getPeriodicidade(), id, new Periodicidade()));
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
