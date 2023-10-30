package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.enums.TipoHistoricoVET;

import java.util.Date;
import java.util.List;

@Table(nome = "historico_vet")
public class HistoricoVET extends AbstractDTO implements DTO {
    private TipoHistoricoVET tipo;
    private Date data;

    private List<Item> itens;

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
        return getTipo().ordinal();
    }

    @Column(nome = "tipo")
    @Setter
    public void setTipoWithInt(int ord) {
        setTipo(TipoHistoricoVET.get(ord));
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

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
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
