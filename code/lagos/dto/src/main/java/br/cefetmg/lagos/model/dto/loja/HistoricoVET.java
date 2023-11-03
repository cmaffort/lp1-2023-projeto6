package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.enums.IntEnum;
import br.cefetmg.lagos.model.dto.enums.TipoHistoricoVET;

import java.util.Date;
import java.util.List;

@Table(nome = "historico_vet")
public class HistoricoVET extends AbstractDTO<HistoricoVET> implements DTO<HistoricoVET> {
    private TipoHistoricoVET tipo;
    private Date data;

    private Loja loja;

    private long id;

    public TipoHistoricoVET getTipo() {
        return tipo;
    }

    public void setTipo(TipoHistoricoVET tipo) {
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
        setTipo(IntEnum.getEnumForInt(ord, TipoHistoricoVET.class));
    }

    @Column(nome = "data")
    @Getter
    public Date getData() {
        return data;
    }

    @Column(nome = "data")
    @Setter
    public void setData(Date data) {
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

    @Column(nome = "loja__fk")
    @Getter
    public long getLojaAsLong() {
        return getRelatedAsLong(getLoja());
    }

    @Column(nome = "loja__fk")
    @Setter
    public void setLojaWithLong(long id) {
        setLoja(setRelatedWithLong(getLoja(), id, new Loja()));
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
