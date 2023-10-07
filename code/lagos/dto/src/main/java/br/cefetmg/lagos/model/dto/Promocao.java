package br.cefetmg.lagos.model.dto;

import java.util.List;

public class Promocao implements DTO {
    private boolean fidelidade;
    private float porcentagem;

    private List<Venda> vendas;
    private List<Produto> produtos;
    private Periodicidade periodicidade;
    private Loja loja;

    private long id;

    public boolean isFidelidade() {
        return fidelidade;
    }

    public void setFidelidade(boolean fidelidade) {
        this.fidelidade = fidelidade;
    }

    public float getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(float porcentagem) {
        this.porcentagem = porcentagem;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Periodicidade getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(Periodicidade periodicidade) {
        this.periodicidade = periodicidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
