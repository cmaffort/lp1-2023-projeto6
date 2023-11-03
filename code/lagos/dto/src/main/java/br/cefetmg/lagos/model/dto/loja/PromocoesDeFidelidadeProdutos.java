package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

@Table(nome = "promocoes_de_fidelidade__produtos")
public class PromocoesDeFidelidadeProdutos extends AbstractDTO<PromocoesDeFidelidadeProdutos> implements DTO<PromocoesDeFidelidadeProdutos> {
    private PromocaoDeFidelidade promocaoDeFidelidade;
    private Produto produto;

    private long id;

    @Related(nome = "promocao_de_fidelidade")
    @Getter
    public PromocaoDeFidelidade getPromocaoDeFidelidade() {
        return promocaoDeFidelidade;
    }

    @Related(nome = "promocao_de_fidelidade")
    @Setter
    public void setPromocaoDeFidelidade(PromocaoDeFidelidade promocaoDeFidelidade) {
        this.promocaoDeFidelidade = promocaoDeFidelidade;
    }

    @Column(nome = "promocao_de_fidelidade__fk")
    @Getter
    public long getPromocaoDeFidelidadeAsLong() {
        return getRelatedAsLong(getPromocaoDeFidelidade());
    }

    @Column(nome = "promocao_de_fidelidade__fk")
    @Setter
    public void setPromocaoDeFidelidadeWithLong(long id) {
        setPromocaoDeFidelidade(setRelatedWithLong(getPromocaoDeFidelidade(), id, new PromocaoDeFidelidade()));
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
