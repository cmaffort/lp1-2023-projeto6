package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

@Table(nome = "produto_compra")
public class ProdutoCompra extends AbstractDTO<ProdutoCompra> implements DTO<ProdutoCompra> {
    private Integer quantidade;
    private Double precoUnitario;

    private Produto produto;
    private Compra compra;

    private Long id;

    @Column(nome = "quantidade", tipo = Integer.class)
    @Getter
    public Integer getQuantidade() {
        return quantidade;
    }

    @Column(nome = "quantidade", tipo = Integer.class)
    @Setter
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Column(nome = "preco_unitario", tipo = Double.class)
    @Getter
    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    @Column(nome = "preco_unitario", tipo = Double.class)
    @Setter
    public void setPrecoUnitario(Double precoUnitario) {
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

    @Column(nome = "produto__fk", tipo = Long.class)
    @Getter
    public Long getProdutoAsLong() {
        return getRelatedAsLong(getProduto());
    }

    @Column(nome = "produto__fk", tipo = Long.class)
    @Setter
    public void setProdutoWithLong(Long id) {
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

    @Column(nome = "compra__fk", tipo = Long.class)
    @Getter
    public Long getCompraAsLong() {
        return getRelatedAsLong(getCompra());
    }

    @Column(nome = "compra__fk", tipo = Long.class)
    @Setter
    public void setCompraWithLong(Long id) {
        setCompra(setRelatedWithLong(getCompra(), id, new Compra()));
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
