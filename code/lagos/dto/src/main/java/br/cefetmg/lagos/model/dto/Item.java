package br.cefetmg.lagos.model.dto;

public class Item implements DTO {
    private double preco;
    private int quantidade;
    private float porcentagemPromocao;

    private Produto produto;
    private HistoricoVET historicoVET;
    private Loja loja;

    private long id;

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getPorcentagemPromocao() {
        return porcentagemPromocao;
    }

    public void setPorcentagemPromocao(float porcentagemPromocao) {
        this.porcentagemPromocao = porcentagemPromocao;
    }
}
