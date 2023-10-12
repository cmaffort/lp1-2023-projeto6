package br.cefetmg.lagos.model.dto;

import java.util.Date;
import java.util.List;

public class PromocaoDeFidelidade implements DTO {
    private Boolean ativa;
    private Float porcentagem;
    private Date maximoCadastro;

    private List<Venda> vendas;
    private List<Produto> produtos;
    private Periodicidade periodicidade;
    private Loja loja;

    private Long id;

    public Boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public Float getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Float porcentagem) {
        this.porcentagem = porcentagem;
    }

    public Date getMaximoCadastro() {
        return maximoCadastro;
    }

    public void setMaximoCadastro(Date maximoCadastro) {
        this.maximoCadastro = maximoCadastro;
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
