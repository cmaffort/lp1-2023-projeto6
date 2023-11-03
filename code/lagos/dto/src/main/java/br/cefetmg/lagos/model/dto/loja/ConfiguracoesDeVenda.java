package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.enums.Bandeira;
import br.cefetmg.lagos.model.dto.enums.MetodosPagamento;

import java.sql.Blob;
import java.sql.Date;
import java.util.List;

@Table(nome = "configuracoes_de_venda")
public class ConfiguracoesDeVenda extends AbstractDTO<ConfiguracoesDeVenda> implements DTO<ConfiguracoesDeVenda> {
    private Float limiteDeDesconto;
    private Float taxaDeJurosAoMes;
    private List<MetodosPagamento> metodosAceitos;
    private List<Bandeira> bandeirasAceitas;
    private Float porcentagemComissao;

    private Loja loja;

    @Column(nome = "limite_de_desconto", tipo = Float.class)
    @Getter
    public Float getLimiteDeDesconto() {
        return limiteDeDesconto;
    }

    @Column(nome = "limite_de_desconto", tipo = Float.class)
    @Setter
    public void setLimiteDeDesconto(Float limiteDeDesconto) {
        this.limiteDeDesconto = limiteDeDesconto;
    }

    @Column(nome = "taxa_de_juros_ao_mes", tipo = Float.class)
    @Getter
    public Float getTaxaDeJurosAoMes() {
        return taxaDeJurosAoMes;
    }

    @Column(nome = "taxa_de_juros_ao_mes", tipo = Float.class)
    @Setter
    public void setTaxaDeJurosAoMes(Float taxaDeJurosAoMes) {
        this.taxaDeJurosAoMes = taxaDeJurosAoMes;
    }

    public List<MetodosPagamento> getMetodosAceitos() {
        return metodosAceitos;
    }

    public void setMetodosAceitos(List<MetodosPagamento> metodosAceitos) {
        this.metodosAceitos = metodosAceitos;
    }

    // TODO: Implementar list<int> para blob e o inverso, usar Gson

    @Column(nome = "metodos_aceitos", tipo = Blob.class)
    @Getter
    public Blob getMetodosAceitosAsBlob() {
        return null;
    }

    @Column(nome = "metodos_aceitos", tipo = Blob.class)
    @Setter
    public void setMetodosAceitosWithBlob(Blob metodosAceitos) {

    }

    public List<Bandeira> getBandeirasAceitas() {
        return bandeirasAceitas;
    }

    public void setBandeirasAceitas(List<Bandeira> bandeirasAceitas) {
        this.bandeirasAceitas = bandeirasAceitas;
    }

    // TODO: Implementar list<int> para blob e o inverso, usar Gson

    @Column(nome = "bandeiras_aceitas", tipo = Blob.class)
    @Getter
    public Blob getBandeirasAceitasAsBlob() {
        return null;
    }

    @Column(nome = "bandeiras_aceitas", tipo = Blob.class)
    @Setter
    public void setBandeirasAceitasWithBlob(Blob bandeirasAceitas) {

    }

    @Column(nome = "porcentagem_comissao", tipo = Float.class)
    @Getter
    public Float getPorcentagemComissao() {
        return porcentagemComissao;
    }

    @Column(nome = "porcentagem_comissao", tipo = Float.class)
    @Setter
    public void setPorcentagemComissao(Float porcentagemComissao) {
        this.porcentagemComissao = porcentagemComissao;
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

    @Column(nome = "pk", tipo = Long.class)
    @Getter
    public Long getId() {
        return getRelatedAsLong(getLoja());
    }

    @Column(nome = "pk", tipo = Long.class)
    @Setter
    public void setId(Long id) {
        setLoja(setRelatedWithLong(getLoja(), id, new Loja()));
    }
}
