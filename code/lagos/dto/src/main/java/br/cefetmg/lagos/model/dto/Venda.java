package br.cefetmg.lagos.model.dto;

import java.util.List;

public class Venda extends HistoricoVET implements DTO {
    private float desconto;

    private UsuarioLoja caixeiro;
    private Funcionario vendedor;
    private Cliente cliente;
    private List<Promocao> promocoes;
    private Loja loja;

    private long id;

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public UsuarioLoja getCaixeiro() {
        return caixeiro;
    }

    public void setCaixeiro(UsuarioLoja caixeiro) {
        this.caixeiro = caixeiro;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Funcionario vendedor) {
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

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}
