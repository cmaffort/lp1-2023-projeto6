package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

@Table(nome = "item")
public class Item extends AbstractDTO<Item> implements DTO<Item> {
    private Double preco;
    private Integer quantidade;

    private Produto produto;
    private HistoricoVET historicoVET;

    private Long id;

    @Column(nome = "preco", tipo = Double.class)
    @Getter
    public Double getPreco() {
        return preco;
    }

    @Column(nome = "preco", tipo = Double.class)
    @Setter
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Column(nome = "quantidade", tipo = Integer.class)
    @Getter
    public Integer getQuantidade() {
        return quantidade;
    }

    @Column(nome = "quantidade", tipo = Integer.class)
    @Setter
    public void setQuantidade(Integer quantidade) {
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

    @Column(nome = "produto__fk", tipo = Long.class)
    @Getter
    public Long getProdutoAsLong() {
        return getRelatedAsLong(getProduto());
    }

    @Column(nome = "produto__fk", tipo = Long.class)
    @Setter
    public void setProdutoWithLong(Long id) {
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

    @Column(nome = "historico_vet__fk", tipo = Long.class)
    @Getter
    public Long getHistoricoVETAsLong() {
        return getRelatedAsLong(getHistoricoVET());
    }

    @Column(nome = "historico_vet__fk", tipo = Long.class)
    @Setter
    public void setHistoricoVETWithLong(Long id) {
        setHistoricoVET(setRelatedWithLong(getHistoricoVET(), id, new HistoricoVET()));
    }

    @Column(nome = "pk", tipo = Long.class)
    @Getter
    public Long getId() {
        return id;
    }

    @Column(nome = "pk", tipo = Long.class)
    @Setter
    public void setId(Long id) {
        this.id = id;
    }
}
