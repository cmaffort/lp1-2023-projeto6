package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

@Table(nome = "promocoes__produtos")
public class PromocoesProdutos extends AbstractDTO<PromocoesProdutos> implements DTO<PromocoesProdutos> {
    private Promocao promocao;
    private Produto produto;

    private long id;

    @Related(nome = "promocao")
    @Getter
    public Promocao getPromocao() {
        return promocao;
    }

    @Related(nome = "promocao")
    @Setter
    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    @Column(nome = "promocao__fk")
    @Getter
    public long getPromocaoAsLong() {
        return getRelatedAsLong(getPromocao());
    }

    @Column(nome = "promocao__fk")
    @Setter
    public void setPromocaoWithLong(long id) {
        setPromocao(setRelatedWithLong(getPromocao(), id, new Promocao()));
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
