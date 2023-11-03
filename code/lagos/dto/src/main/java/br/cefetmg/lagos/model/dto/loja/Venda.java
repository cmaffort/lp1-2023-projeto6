package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

@Table(nome = "venda")
public class Venda extends AbstractDTO<Venda> implements DTO<Venda>, HistoricoVETAdapter<Venda> {
    private float desconto;
    private int numeroDeParcelas;

    private Caixa caixa;
    private Funcionario funcionario;
    private Cliente cliente;

    private HistoricoVET historicoVET;

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

    @Related(nome = "caixa")
    @Getter
    public Caixa getCaixa() {
        return caixa;
    }

    @Related(nome = "caixa")
    @Setter
    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    @Column(nome = "caixa__fk")
    @Getter
    public long getCaixaAsLong() {
        return getRelatedAsLong(getCaixa());
    }

    @Column(nome = "caixa__fk")
    @Setter
    public void setCaixaWithLong(long id) {
        setCaixa(setRelatedWithLong(getCaixa(), id, new Caixa()));
    }

    @Related(nome = "funcionario")
    @Getter
    public Funcionario getFuncionario() {
        return funcionario;
    }

    @Related(nome = "funcionario")
    @Setter
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Column(nome = "funcionario__fk")
    @Getter
    public long getFuncionarioAsLong() {
        return getRelatedAsLong(getFuncionario());
    }

    @Column(nome = "funcionario__fk")
    @Setter
    public void setFuncionarioWith(long id) {
        setFuncionario(setRelatedWithLong(getFuncionario(), id, new Funcionario()));
    }

    @Related(nome = "cliente")
    @Getter
    public Cliente getCliente() {
        return cliente;
    }

    @Related(nome = "cliente")
    @Setter
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Column(nome = "cliente__fk")
    @Getter
    public long getClienteAsLong() {
        return getRelatedAsLong(getCliente());
    }

    @Column(nome = "cliente__fk")
    @Setter
    public void setClienteWith(long id) {
        setCliente(setRelatedWithLong(getCliente(), id, new Cliente()));
    }

    @Related(nome = "historico_vet")
    @Getter
    public HistoricoVET getHistoricoVET() {
        return historicoVET;
    }


    @Related(nome = "historico_vet")
    @Setter
    public void setHistoricoVET(HistoricoVET historicoVET) {
        this.historicoVET = historicoVET;
    }

    @Column(nome = "pk")
    @Getter
    public long getId() {
        return getRelatedAsLong(getHistoricoVET());
    }

    @Column(nome = "pk")
    @Setter
    public void setId(long id) {
        setHistoricoVET(setRelatedWithLong(getHistoricoVET(), id, new HistoricoVET()));
    }
}
