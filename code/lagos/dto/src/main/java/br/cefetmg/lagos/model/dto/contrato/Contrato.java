package br.cefetmg.lagos.model.dto.contrato;

import br.cefetmg.lagos.model.dto.Periodicidade;
import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

import java.sql.Blob;
import java.sql.Date;

@Table(nome = "contrato")
public class Contrato extends AbstractDTO implements DTO {
    private boolean ativo;
    private String descricao;
    private double preco;
    private Blob documento;
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

    @Column(nome = "documento")
    @Getter
    public Blob getDocumento() {
        return documento;
    }

    @Column(nome = "documento")
    @Setter
    public void setDocumento(Blob documento) {
        this.documento = documento;
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

    public Periodicidade getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(Periodicidade periodicidade) {
        this.periodicidade = periodicidade;
    }

    @Column(nome = "periodicidade__fk")
    @Getter
    public long getPeriodicidadeAsLong() {
        return getRelatedDTOAsLong(getPeriodicidade());
    }

    @Column(nome = "periodicidade__fk")
    @Setter
    public void setPeriodicidadeWithLong(long id) {
        setPeriodicidade((Periodicidade) setRelatedWithLong(getPeriodicidade(), id, new Periodicidade()));
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
