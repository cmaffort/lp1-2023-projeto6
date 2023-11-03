package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.contrato.Loja;

@Table(nome = "item")
public class Item extends AbstractDTO<Item> implements DTO<Item> {
    private double preco;
    private int quantidade;

    private Produto produto;
    private HistoricoVET historicoVET;

    private long id;

    @Column(nome = "preco")
    @Getter
    public double getPreco() {
        return preco;
    }

    @Column(nome = "preco")
    @Setter
    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Column(nome = "quantidade")
    @Getter
    public int getQuantidade() {
        return quantidade;
    }

    @Column(nome = "quantidade")
    @Setter
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Related(nome = "produto")
    @Getter
    public Produto getProduto() {
        return produto;
    }


    @Related(nome = "produto")
    @Setter
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Column(nome = "produto__fk")
    @Getter
    public long getProdutoAsLong() {
        return getRelatedAsLong(getProduto());
    }

    @Column(nome = "produto__fk")
    @Setter
    public void setProdutoWithLong(long id) {
        setProduto(setRelatedWithLong(getProduto(), id, new Produto()));
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

    @Column(nome = "historico_vet__fk")
    @Getter
    public long getHistoricoVETAsLong() {
        return getRelatedAsLong(getHistoricoVET());
    }

    @Column(nome = "historico_vet__fk")
    @Setter
    public void setHistoricoVETWithLong(long id) {
        setHistoricoVET(setRelatedWithLong(getHistoricoVET(), id, new HistoricoVET()));
    }

    @Column(nome = "pk")
    @Getter
    public long getId() {
        return id;
    }

    @Column(nome = "pk")
    @Setter
    public void setId(long id) {
        this.id = id;
    }
}
