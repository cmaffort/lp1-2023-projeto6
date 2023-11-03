package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.List;

@Table(nome = "produto")
public class Produto extends AbstractDTO<Produto> implements DTO<Produto> {
    private String codigo;
    private String nome;
    private int quantidade;
    private double preco;

    private Loja loja;

    private long id;

    @Column(nome = "codigo")
    @Getter
    public String getCodigo() {
        return codigo;
    }

    @Column(nome = "codigo")
    @Setter
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Column(nome = "nome")
    @Getter
    public String getNome() {
        return nome;
    }

    @Column(nome = "nome")
    @Setter
    public void setNome(String nome) {
        this.nome = nome;
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

    @Column(nome = "loja__fk")
    @Getter
    public long getLojaAsLong() {
        return getRelatedAsLong(getLoja());
    }

    @Column(nome = "loja__fk")
    @Setter
    public void setLojaWithLong(long id) {
        setLoja(setRelatedWithLong(getLoja(), id, new Loja()));
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
