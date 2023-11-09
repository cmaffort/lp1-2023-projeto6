package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.enums.IntEnum;
import br.cefetmg.lagos.model.dto.enums.TipoFluxoDeCaixa;

import java.time.LocalDateTime;

@Table(nome = "fluxo_de_caixa")
@PrimaryKey(nome = "pk")
public class FluxoDeCaixa extends AbstractDTO<FluxoDeCaixa> implements DTO<FluxoDeCaixa> {
    private Double dinheiroEmCaixa;
    private TipoFluxoDeCaixa tipo;
    private LocalDateTime hora;

    private Caixa caixa;

    private Long id;

    @Column(nome = "dinheiro_em_caixa", tipo = Double.class)
    @NotNull
    @Getter
    public Double getDinheiroEmCaixa() {
        return dinheiroEmCaixa;
    }

    @Column(nome = "dinheiro_em_caixa", tipo = Double.class)
    @NotNull
    @Setter
    public void setDinheiroEmCaixa(Double dinheiroEmCaixa) {
        this.dinheiroEmCaixa = dinheiroEmCaixa;
    }

    public TipoFluxoDeCaixa getTipo() {
        return tipo;
    }

    public void setTipo(TipoFluxoDeCaixa tipo) {
        this.tipo = tipo;
    }

    @Column(nome = "tipo", tipo = Integer.class)
    @NotNull
    @Getter
    public Integer getTipoAsInt() {
        return IntEnum.getIntForEnum(tipo);
    }

    @Column(nome = "tipo", tipo = Integer.class)
    @NotNull
    @Setter
    public void setTipoWithInt(Integer ord) {
        tipo = IntEnum.getEnumForInt(ord, TipoFluxoDeCaixa.class);
    }

    @Column(nome = "hora", tipo = LocalDateTime.class)
    @NotNull
    @Getter
    public LocalDateTime getHora() {
        return hora;
    }

    @Column(nome = "hora", tipo = LocalDateTime.class)
    @NotNull
    @Setter
    public void setHora(LocalDateTime hora) {
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

    @Column(nome = "caixa__fk", tipo = Long.class)
    @NotNull
    @Getter
    public Long getCaixaAsLong() {
        return getRelatedAsLong(caixa);
    }

    @Column(nome = "caixa__fk", tipo = Long.class)
    @NotNull
    @Setter
    public void setCaixaWithLong(Long id) {
        caixa = setRelatedWithLong(caixa, id, new Caixa());
    }

    @Column(nome = "pk", tipo = Long.class)
    @Getter
    public Long getId() {
        return id;
    }

    @Column(nome = "pk", tipo = Long.class)
    @Setter
    public void setId(Long id) {
        this.id = id;
    }
}
