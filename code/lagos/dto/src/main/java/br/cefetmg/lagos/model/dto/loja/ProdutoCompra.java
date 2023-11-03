package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

@Table(nome = "produto_compra")
public class ProdutoCompra extends AbstractDTO<ProdutoCompra> implements DTO<ProdutoCompra> {
    private int quantidade;
    private double precoUnitario;

    private Produto produto;
    private Compra compra;

    private long id;

    @Column(nome = "quantidade")
    @Getter
    public int getQuantidade() {
        return quantidade;
    }

    @Column(nome = "quantidade")
    @Setter
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Column(nome = "preco_unitario")
    @Getter
    public double getPrecoUnitario() {
        return precoUnitario;
    }

    @Column(nome = "preco_unitario")
    @Setter
    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    @Related(nome = "produto")
    @Getter
    public Produto getProduto() {
        return produto;
    }

    @Related(nome = "produto")
    @Setter
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Column(nome = "produto__fk")
    @Getter
    public long getProdutoAsLong() {
        return getRelatedAsLong(getProduto());
    }

    @Column(nome = "produto__fk")
    @Setter
    public void setProdutoWithLong(long id) {
        setProduto(setRelatedWithLong(getProduto(), id, new Produto()));
    }

    @Related(nome = "compra")
    @Getter
    public Compra getCompra() {
        return compra;
    }

    @Related(nome = "compra")
    @Setter
    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @Column(nome = "compra__fk")
    @Getter
    public long getCompraAsLong() {
        return getRelatedAsLong(getCompra());
    }

    @Column(nome = "compra__fk")
    @Setter
    public void setCompraWithLong(long id) {
        setCompra(setRelatedWithLong(getCompra(), id, new Compra()));
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
