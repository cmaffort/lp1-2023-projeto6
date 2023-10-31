package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.enums.TipoFluxoDeCaixa;

import java.sql.Timestamp;

@Table(nome = "fluxo_de_caixa")
public class FluxoDeCaixa extends AbstractDTO implements DTO {
    private double dinheiroEmCaixa;
    private TipoFluxoDeCaixa tipo;
    private Timestamp hora;

    private Caixa caixa;

    private long id;

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

    public TipoFluxoDeCaixa getTipo() {
        return tipo;
    }

    public void setTipo(TipoFluxoDeCaixa tipo) {
        this.tipo = tipo;
    }

    @Column(nome = "tipo")
    @Getter
    public int getTipoAsInt() {
        return getTipo().ordinal();
    }

    @Column(nome = "tipo")
    @Setter
    public void setTipoWithInt(int ord) {
        setTipo(TipoFluxoDeCaixa.get(ord));
    }

    @Column(nome = "hora")
    @Getter
    public Timestamp getHora() {
        return hora;
    }

    @Column(nome = "hora")
    @Setter
    public void setHora(Timestamp hora) {
        this.hora = hora;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
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
