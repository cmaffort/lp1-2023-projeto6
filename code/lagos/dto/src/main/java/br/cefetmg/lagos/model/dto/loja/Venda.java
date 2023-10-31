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

    private Caixa caixa;
    private Funcionario funcionario;
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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
