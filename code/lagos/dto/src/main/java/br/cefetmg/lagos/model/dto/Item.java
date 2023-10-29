package br.cefetmg.lagos.model.dto;

public class Item implements DTO {
    private Double preco;
    private Integer quantidade;

    private Produto produto;
    private HistoricoVET historicoVET;
    private Loja loja;

    private long id;

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public HistoricoVET getHistoricoVET() {
        return historicoVET;
    }

    public void setHistoricoVET(HistoricoVET historicoVET) {
        this.historicoVET = historicoVET;
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
