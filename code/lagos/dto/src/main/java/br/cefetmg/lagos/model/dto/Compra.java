package br.cefetmg.lagos.model.dto;

import java.util.Date;
import java.util.List;

public class Compra implements DTO {
    private Date dataDeCompra;
    private Date dataDeChegada;

    private List<ProdutoCompra> produtosDeCompra;
    private Loja loja;

    private long id;

    public Date getDataDeCompra() {
        return dataDeCompra;
    }

    public void setDataDeCompra(Date dataDeCompra) {
        this.dataDeCompra = dataDeCompra;
    }

    public Date getDataDeChegada() {
        return dataDeChegada;
    }

    public void setDataDeChegada(Date dataDeChegada) {
        this.dataDeChegada = dataDeChegada;
    }

    public List<ProdutoCompra> getProdutosDeCompra() {
        return produtosDeCompra;
    }

    public void setProdutosDeCompra(List<ProdutoCompra> produtosDeCompra) {
        this.produtosDeCompra = produtosDeCompra;
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
