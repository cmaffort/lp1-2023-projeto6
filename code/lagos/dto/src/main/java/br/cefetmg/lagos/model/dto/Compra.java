package br.cefetmg.lagos.model.dto;

import java.util.Date;

public class Compra implements DTO {
    private int quantidade;
    private Date dataDeCompra;
    private Date dataDeChegada;
    private boolean precoUnitario;

    private Produto produto;
    private Loja loja;

    private long id;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

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

    public boolean isPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(boolean precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
