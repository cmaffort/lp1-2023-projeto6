package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.enums.Bandeira;
import br.cefetmg.lagos.model.dto.enums.MetodosPagamento;

import java.sql.Blob;
import java.util.List;

@Table(nome = "configuracoes_de_venda")
public class ConfiguracoesDeVenda extends AbstractDTO implements DTO {
    private float limiteDeDesconto;
    private float taxaDeJurosAoMes;
    private List<MetodosPagamento> metodosAceitos;
    private List<Bandeira> bandeirasAceitas;
    private float porcentagemComissao;

    private Loja loja;

    private long id;

    @Column(nome = "limite_de_desconto")
    @Getter
    public float getLimiteDeDesconto() {
        return limiteDeDesconto;
    }

    @Column(nome = "limite_de_desconto")
    @Setter
    public void setLimiteDeDesconto(float limiteDeDesconto) {
        this.limiteDeDesconto = limiteDeDesconto;
    }

    @Column(nome = "taxa_de_juros_ao_mes")
    @Getter
    public float getTaxaDeJurosAoMes() {
        return taxaDeJurosAoMes;
    }

    @Column(nome = "taxa_de_juros_ao_mes")
    @Setter
    public void setTaxaDeJurosAoMes(float taxaDeJurosAoMes) {
        this.taxaDeJurosAoMes = taxaDeJurosAoMes;
    }

    public List<MetodosPagamento> getMetodosAceitos() {
        return metodosAceitos;
    }

    public void setMetodosAceitos(List<MetodosPagamento> metodosAceitos) {
        this.metodosAceitos = metodosAceitos;
    }

    // TODO: Implement getting an setting blobs

    @Column(nome = "metodos_aceitos")
    @Getter
    public Blob getMetodosAceitosAsBlob() {return null;}

    @Column(nome = "metodos_aceitos")
    @Setter
    public void setMetodosAceitosWithBlob(Blob metodosAceitos) {}

    public List<Bandeira> getBandeirasAceitas() {
        return bandeirasAceitas;
    }

    public void setBandeirasAceitas(List<Bandeira> bandeirasAceitas) {
        this.bandeirasAceitas = bandeirasAceitas;
    }

    @Column(nome = "bandeiras_aceitas")
    @Getter
    public Blob getBandeirasAceitasAsBlob() {return null;}

    @Column(nome = "bandeiras_aceitas")
    @Setter
    public void setBandeirasAceitasWithBlob(Blob bandeirasAceitas) {}

    @Column(nome = "porcentagem_comissao")
    @Getter
    public float getPorcentagemComissao() {
        return porcentagemComissao;
    }

    @Column(nome = "porcentagem_comissao")
    @Setter
    public void setPorcentagemComissao(float porcentagemComissao) {
        this.porcentagemComissao = porcentagemComissao;
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
