package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

import java.util.Date;
import java.util.List;

@Table(nome = "compra")
public class Compra extends AbstractDTO<Compra> implements DTO<Compra> {
    private Date dataDeCompra;
    private Date dataDeChegada;

    private Loja loja;

    private long id;

    @Column(nome = "data_de_compra")
    @Getter
    public Date getDataDeCompra() {
        return dataDeCompra;
    }

    @Column(nome = "data_de_compra")
    @Setter
    public void setDataDeCompra(Date dataDeCompra) {
        this.dataDeCompra = dataDeCompra;
    }

    @Column(nome = "data_de_chegada")
    @Getter
    public Date getDataDeChegada() {
        return dataDeChegada;
    }

    @Column(nome = "data_de_chegada")
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
    @Getter
    public void setId(long id) {
        this.id = id;
    }
}
