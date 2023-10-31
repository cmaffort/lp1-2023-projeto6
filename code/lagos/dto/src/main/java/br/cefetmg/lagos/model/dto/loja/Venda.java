package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.List;

@Table(nome = "venda")
public class Venda extends HistoricoVET implements DTO {
    private float desconto;
    private int numeroDeParcelas;

    private List<Promocao> promocoes;
    private List<PromocaoDeFidelidade> promocoesDeFidelidade;

    private Caixa caixa;
    private Vendedor vendedor;
    private Cliente cliente;

    @Column(nome = "desconto")
    @Getter
    public float getDesconto() {
        return desconto;
    }

    @Column(nome = "desconto")
    @Setter
    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    @Column(nome = "numero_de_parcelas")
    @Getter
    public int getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    @Column(nome = "numero_de_parcelas")
    @Setter
    public void setNumeroDeParcelas(int numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
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
}
