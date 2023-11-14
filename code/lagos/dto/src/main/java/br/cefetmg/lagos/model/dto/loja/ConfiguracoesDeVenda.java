package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.enums.Bandeira;
import br.cefetmg.lagos.model.dto.enums.MetodosPagamento;

import java.util.List;

@Table(nome = "configuracoes_de_venda")
@PrimaryKey(nome = "pk")
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

    @Column(nome = "metodos_aceitos", tipo = byte[].class)
    @Getter
    public byte[] getMetodosAceitosAsBytes() {
        return null;
    }

    @Column(nome = "metodos_aceitos", tipo = byte[].class)
    @Setter
    public void setMetodosAceitosWithBytes(byte[] metodosAceitos) {

    }

    public List<Bandeira> getBandeirasAceitas() {
        return bandeirasAceitas;
    }

    public void setBandeirasAceitas(List<Bandeira> bandeirasAceitas) {
        this.bandeirasAceitas = bandeirasAceitas;
    }

    // TODO: Implementar list<int> para blob e o inverso, usar Gson

    @Column(nome = "bandeiras_aceitas", tipo = byte[].class)
    @Getter
    public byte[] getBandeirasAceitasAsBytes() {
        return null;
    }

    @Column(nome = "bandeiras_aceitas", tipo = byte[].class)
    @Setter
    public void setBandeirasAceitasWithBytes(byte[] bandeirasAceitas) {

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
    @NotNull
    @Getter
    public Long getId() {
        return getRelatedAsLong(getLoja());
    }

    @Column(nome = "pk", tipo = Long.class)
    @NotNull
    @Setter
    public void setId(Long id) {
        setLoja(setRelatedWithLong(getLoja(), id, new Loja()));
    }
}
