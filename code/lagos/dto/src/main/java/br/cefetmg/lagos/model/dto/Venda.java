package br.cefetmg.lagos.model.dto;

import java.util.List;

public class Venda extends HistoricoVET implements DTO {
    private Float desconto;

    private Caixeiro caixeiro;
    private Vendedor vendedor;
    private Cliente cliente;
    private List<Promocao> promocoes;
    private List<PromocaoDeFidelidade> promocoesDeFidelidade;
    private Loja loja;

    private Long id;

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    public Caixeiro getCaixeiro() {
        return caixeiro;
    }

    public void setCaixeiro(Caixeiro caixeiro) {
        this.caixeiro = caixeiro;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    @Override
    public Loja getLoja() {
        return loja;
    }

    @Override
    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
