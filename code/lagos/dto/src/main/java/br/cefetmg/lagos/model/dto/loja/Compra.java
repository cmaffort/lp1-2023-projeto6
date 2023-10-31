package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

import java.util.Date;
import java.util.List;

@Table(nome = "compra")
public class Compra extends AbstractDTO implements DTO {
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
    @Getter
    public void setId(long id) {
        this.id = id;
    }
}
