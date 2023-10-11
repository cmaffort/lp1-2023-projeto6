package br.cefetmg.lagos.model.dto;

import java.util.List;

public class Produto implements DTO {
    private String codigo;
    private String nome;
    private Integer quantidade;
    private Double preco;

    private List<ProdutoCompra> produtoCompras;
    private List<Item> itens;
    private List<Promocao> promocoes;
    private List<PromocaoDeFidelidade> promocoesDeFidelidade;
    private Loja loja;

    private Long id;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<ProdutoCompra> getProdutoCompras() {
        return produtoCompras;
    }

    public void setProdutoCompras(List<ProdutoCompra> produtoCompras) {
        this.produtoCompras = produtoCompras;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public List<Promocao> getPromocoes() {
        return promocoes;
    }

    public void setPromocoes(List<Promocao> promocoes) {
        this.promocoes = promocoes;
    }

    public List<PromocaoDeFidelidade> getPromocoesDeFidelidade() {
        return promocoesDeFidelidade;
    }

    public void setPromocoesDeFidelidade(List<PromocaoDeFidelidade> promocoesDeFidelidade) {
        this.promocoesDeFidelidade = promocoesDeFidelidade;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
