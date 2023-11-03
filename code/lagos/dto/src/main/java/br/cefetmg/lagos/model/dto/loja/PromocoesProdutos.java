package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

@Table(nome = "promocoes__produtos")
public class PromocoesProdutos extends AbstractDTO<PromocoesProdutos> implements DTO<PromocoesProdutos> {
    private Promocao promocao;
    private Produto produto;

    private Long id;

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

    @Column(nome = "promocao__fk", tipo = Long.class)
    @Getter
    public Long getPromocaoAsLong() {
        return getRelatedAsLong(getPromocao());
    }

    @Column(nome = "promocao__fk", tipo = Long.class)
    @Setter
    public void setPromocaoWithLong(Long id) {
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
