package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

import java.util.List;

@Table(nome = "caixa")
public class Caixa extends AbstractDTO implements DTO {
    private boolean aberto;
    private double dinheiroEmCaixa;

    private Caixeiro caixeiro;
    private List<FluxoDeCaixa> fluxosDeCaixa;
    private Loja loja;

    private long id;

    @Column(nome = "aberto")
    @Getter
    public boolean isAberto() {
        return aberto;
    }

    @Column(nome = "aberto")
    @Setter
    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    @Column(nome = "dinheiro_em_caixa")
    @Getter
    public double getDinheiroEmCaixa() {
        return dinheiroEmCaixa;
    }

    @Column(nome = "dinheiro_em_caixa")
    @Setter
    public void setDinheiroEmCaixa(double dinheiroEmCaixa) {
        this.dinheiroEmCaixa = dinheiroEmCaixa;
    }

    public Caixeiro getCaixeiro() {
        return caixeiro;
    }

    public void setCaixeiro(Caixeiro caixeiro) {
        this.caixeiro = caixeiro;
    }

    public List<FluxoDeCaixa> getFluxosDeCaixa() {
        return fluxosDeCaixa;
    }

    public void setFluxosDeCaixa(List<FluxoDeCaixa> fluxosDeCaixa) {
        this.fluxosDeCaixa = fluxosDeCaixa;
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
