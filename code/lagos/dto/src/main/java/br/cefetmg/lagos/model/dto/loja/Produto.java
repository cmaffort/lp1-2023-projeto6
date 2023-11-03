package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

@Table(nome = "produto")
public class Produto extends AbstractDTO<Produto> implements DTO<Produto> {
    private String codigo;
    private String nome;
    private Integer quantidade;
    private Double preco;

    private Loja loja;

    private Long id;

    @Column(nome = "codigo", tipo = String.class)
    @Getter
    public String getCodigo() {
        return codigo;
    }

    @Column(nome = "codigo", tipo = String.class)
    @Setter
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Column(nome = "nome", tipo = String.class)
    @Getter
    public String getNome() {
        return nome;
    }

    @Column(nome = "nome", tipo = String.class)
    @Setter
    public void setNome(String nome) {
        this.nome = nome;
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

    @Related(nome = "loja")
    @Getter
    public Loja getLoja() {
        return loja;
    }

    @Related(nome = "loja")
    @Setter
    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    @Column(nome = "loja__fk", tipo = Long.class)
    @Getter
    public Long getLojaAsLong() {
        return getRelatedAsLong(getLoja());
    }

    @Column(nome = "loja__fk", tipo = Long.class)
    @Setter
    public void setLojaWithLong(Long id) {
        setLoja(setRelatedWithLong(getLoja(), id, new Loja()));
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
