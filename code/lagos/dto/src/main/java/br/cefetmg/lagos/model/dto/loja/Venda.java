package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

@Table(nome = "venda")
public class Venda extends AbstractDTO<Venda> implements DTO<Venda>, HistoricoVETAdapter<Venda> {
    private Float desconto;
    private Integer numeroDeParcelas;

    private Caixa caixa;
    private Funcionario funcionario;
    private Cliente cliente;

    private HistoricoVET historicoVET;

    @Column(nome = "desconto", tipo = Float.class)
    @Getter
    public Float getDesconto() {
        return desconto;
    }

    @Column(nome = "desconto", tipo = Float.class)
    @Setter
    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    @Column(nome = "numero_de_parcelas", tipo = Integer.class)
    @Getter
    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    @Column(nome = "numero_de_parcelas", tipo = Integer.class)
    @Setter
    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
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

    @Column(nome = "caixa__fk", tipo = Long.class)
    @Getter
    public Long getCaixaAsLong() {
        return getRelatedAsLong(getCaixa());
    }

    @Column(nome = "caixa__fk", tipo = Long.class)
    @Setter
    public void setCaixaWithLong(Long id) {
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

    @Column(nome = "funcionario__fk", tipo = Long.class)
    @Getter
    public Long getFuncionarioAsLong() {
        return getRelatedAsLong(getFuncionario());
    }

    @Column(nome = "funcionario__fk", tipo = Long.class)
    @Setter
    public void setFuncionarioWith(Long id) {
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

    @Column(nome = "cliente__fk", tipo = Long.class)
    @Getter
    public Long getClienteAsLong() {
        return getRelatedAsLong(getCliente());
    }

    @Column(nome = "cliente__fk", tipo = Long.class)
    @Setter
    public void setClienteWith(Long id) {
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

    @Column(nome = "pk", tipo = Long.class)
    @Getter
    public Long getId() {
        return getRelatedAsLong(getHistoricoVET());
    }

    @Column(nome = "pk", tipo = Long.class)
    @Setter
    public void setId(Long id) {
        setHistoricoVET(setRelatedWithLong(getHistoricoVET(), id, new HistoricoVET()));
    }
}
