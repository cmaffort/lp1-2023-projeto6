package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.enums.IntEnum;
import br.cefetmg.lagos.model.dto.enums.TipoHistoricoVET;

import java.time.LocalDateTime;

@Table(nome = "historico_vet")
@PrimaryKey(nome = "pk")
public class HistoricoVET extends AbstractDTO<HistoricoVET> implements DTO<HistoricoVET> {
    private TipoHistoricoVET tipo;
    private LocalDateTime data;

    private Loja loja;

    private Long id;

    public TipoHistoricoVET getTipo() {
        return tipo;
    }

    public void setTipo(TipoHistoricoVET tipo) {
        this.tipo = tipo;
    }

    @Column(nome = "tipo", tipo = Integer.class)
    @NotNull
    @Getter
    public Integer getTipoAsInt() {
        return IntEnum.getIntForEnum(getTipo());
    }

    @Column(nome = "tipo", tipo = Integer.class)
    @NotNull
    @Setter
    public void setTipoWithInt(Integer ord) {
        setTipo(IntEnum.getEnumForInt(ord, TipoHistoricoVET.class));
    }

    @Column(nome = "data", tipo = LocalDateTime.class)
    @NotNull
    @Getter
    public LocalDateTime getData() {
        return data;
    }

    @Column(nome = "data", tipo = LocalDateTime.class)
    @NotNull
    @Setter
    public void setData(LocalDateTime data) {
        this.data = data;
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

    @Column(nome = "loja__fk", tipo = Long.class)
    @NotNull
    @Getter
    public Long getLojaAsLong() {
        return getRelatedAsLong(getLoja());
    }

    @Column(nome = "loja__fk", tipo = Long.class)
    @NotNull
    @Setter
    public void setLojaWithLong(Long id) {
        setLoja(setRelatedWithLong(getLoja(), id, new Loja()));
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
