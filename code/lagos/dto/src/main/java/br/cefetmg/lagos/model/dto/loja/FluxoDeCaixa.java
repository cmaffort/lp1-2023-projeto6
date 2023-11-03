package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.enums.IntEnum;
import br.cefetmg.lagos.model.dto.enums.TipoFluxoDeCaixa;

import java.sql.Timestamp;

@Table(nome = "fluxo_de_caixa")
public class FluxoDeCaixa extends AbstractDTO<FluxoDeCaixa> implements DTO<FluxoDeCaixa> {
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
        return IntEnum.getIntForEnum(getTipo());
    }

    @Column(nome = "tipo")
    @Setter
    public void setTipoWithInt(int ord) {
        setTipo(IntEnum.getEnumForInt(ord, TipoFluxoDeCaixa.class));
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

    @Related(nome = "caixa")
    @Getter
    public Caixa getCaixa() {
        return caixa;
    }

    @Related(nome = "caixa")
    @Setter
    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    @Column(nome = "caixa__fk")
    @Getter
    public long getCaixaAsLong() {
        return getRelatedAsLong(getCaixa());
    }

    @Column(nome = "caixa__fk")
    @Setter
    public void setCaixaWithLong(long id) {
        setCaixa(setRelatedWithLong(getCaixa(), id, new Caixa()));
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
