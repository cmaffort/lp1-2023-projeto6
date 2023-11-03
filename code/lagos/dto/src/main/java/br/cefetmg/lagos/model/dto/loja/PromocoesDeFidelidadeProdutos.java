package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

@Table(nome = "promocoes_de_fidelidade__produtos")
public class PromocoesDeFidelidadeProdutos extends AbstractDTO<PromocoesDeFidelidadeProdutos> implements DTO<PromocoesDeFidelidadeProdutos> {
    private PromocaoDeFidelidade promocaoDeFidelidade;
    private Produto produto;

    private Long id;

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

    @Column(nome = "promocao_de_fidelidade__fk", tipo = Long.class)
    @Getter
    public Long getPromocaoDeFidelidadeAsLong() {
        return getRelatedAsLong(getPromocaoDeFidelidade());
    }

    @Column(nome = "promocao_de_fidelidade__fk", tipo = Long.class)
    @Setter
    public void setPromocaoDeFidelidadeWithLong(Long id) {
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
