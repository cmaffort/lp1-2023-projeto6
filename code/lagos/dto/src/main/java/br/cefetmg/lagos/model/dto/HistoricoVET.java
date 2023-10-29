package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.enums.TipoHistoricoVET;

import java.util.Date;
import java.util.List;

public class HistoricoVET implements DTO {
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

    public Date getData() {
        return data;
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
