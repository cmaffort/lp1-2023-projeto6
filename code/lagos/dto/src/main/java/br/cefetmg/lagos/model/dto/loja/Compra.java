package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

import java.sql.Date;

@Table(nome = "compra")
@PrimaryKey(nome = "pk")
public class Compra extends AbstractDTO<Compra> implements DTO<Compra> {
    private Date dataDeCompra;
    private Date dataDeChegada;

    private Loja loja;

    private Long id;

    @Column(nome = "data_de_compra", tipo = Date.class)
    @NotNull
    @Getter
    public Date getDataDeCompra() {
        return dataDeCompra;
    }

    @Column(nome = "data_de_compra", tipo = Date.class)
    @NotNull
    @Setter
    public void setDataDeCompra(Date dataDeCompra) {
        this.dataDeCompra = dataDeCompra;
    }

    @Column(nome = "data_de_chegada", tipo = Date.class)
    @Getter
    public Date getDataDeChegada() {
        return dataDeChegada;
    }

    @Column(nome = "data_de_chegada", tipo = Date.class)
    @Setter
    public void setDataDeChegada(Date dataDeChegada) {
        this.dataDeChegada = dataDeChegada;
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
    @Getter
    public void setId(Long id) {
        this.id = id;
    }
}
