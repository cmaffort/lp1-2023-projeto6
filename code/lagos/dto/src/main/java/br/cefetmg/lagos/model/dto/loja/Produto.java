package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.List;

@Table(nome = "produto")
public class Produto extends AbstractDTO implements DTO {
    private String codigo;
    private String nome;
    private int quantidade;
    private double preco;

    private List<ProdutoCompra> produtoCompras;
    private List<Item> itens;
    private List<Promocao> promocoes;
    private List<PromocaoDeFidelidade> promocoesDeFidelidade;
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

    public List<ProdutoCompra> getProdutoCompras() {
        return produtoCompras;
    }

    public void setProdutoCompras(List<ProdutoCompra> produtoCompras) {
        this.produtoCompras = produtoCompras;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public List<Promocao> getPromocoes() {
        return promocoes;
    }

    public void setPromocoes(List<Promocao> promocoes) {
        this.promocoes = promocoes;
    }

    public List<PromocaoDeFidelidade> getPromocoesDeFidelidade() {
        return promocoesDeFidelidade;
    }

    public void setPromocoesDeFidelidade(List<PromocaoDeFidelidade> promocoesDeFidelidade) {
        this.promocoesDeFidelidade = promocoesDeFidelidade;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
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
