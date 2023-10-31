package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.Periodicidade;
import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.Date;
import java.util.List;

@Table(nome = "promocao_de_fidelidade")
public class PromocaoDeFidelidade extends AbstractDTO implements DTO {
    private int minVendas;
    private boolean ativa;
    private float porcentagem;
    private Date dataInicio;

    private Periodicidade periodicidade;
    private Loja loja;

    private long id;

    @Column(nome = "min_vendas")
    @Getter
    public int getMinVendas() {
        return minVendas;
    }

    @Column(nome = "min_vendas")
    @Setter
    public void setMinVendas(int minVendas) {
        this.minVendas = minVendas;
    }

    @Column(nome = "ativa")
    @Getter
    public boolean isAtiva() {
        return ativa;
    }

    @Column(nome = "ativa")
    @Setter
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    @Column(nome = "porcentagem")
    @Getter
    public float getPorcentagem() {
        return porcentagem;
    }

    @Column(nome = "porcentagem")
    @Setter
    public void setPorcentagem(float porcentagem) {
        this.porcentagem = porcentagem;
    }

    @Column(nome = "data_inicio")
    @Getter
    public Date getDataInicio() {
        return dataInicio;
    }

    @Column(nome = "data_inicio")
    @Setter
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Periodicidade getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(Periodicidade periodicidade) {
        this.periodicidade = periodicidade;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
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
