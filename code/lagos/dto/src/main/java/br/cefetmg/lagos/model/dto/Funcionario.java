package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.tipos.TipoFuncionario;

import java.util.List;

public class Funcionario extends Pessoa implements DTO {
    private double salario;
    private boolean ativo;
    private double comissao;
    private TipoFuncionario tipo;

    private List<Venda> vendas; // Só se o funcionário for um vendedor
    private Loja loja;

    private long id;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public TipoFuncionario getTipo() {
        return tipo;
    }

    public void setTipo(TipoFuncionario tipo) {
        this.tipo = tipo;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
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
