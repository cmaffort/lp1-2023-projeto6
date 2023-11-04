package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

@Table(nome = "promocoes_de_fidelidade__vendas")
@PrimaryKey(nome = "pk")
public class PromocoesDeFidelidadeVendas extends AbstractDTO<PromocoesDeFidelidadeVendas> implements DTO<PromocoesDeFidelidadeVendas> {
    private PromocaoDeFidelidade promocaoDeFidelidade;
    private Venda venda;

    long id;

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
    @NotNull
    @Getter
    public Long getPromocaoDeFidelidadeAsLong() {
        return getRelatedAsLong(getPromocaoDeFidelidade());
    }

    @Column(nome = "promocao_de_fidelidade__fk", tipo = Long.class)
    @NotNull
    @Setter
    public void setPromocaoDeFidelidadeWithLong(Long id) {
        setPromocaoDeFidelidade(setRelatedWithLong(getPromocaoDeFidelidade(), id, new PromocaoDeFidelidade()));
    }

    @Related(nome = "venda")
    @Getter
    public Venda getVenda() {
        return venda;
    }

    @Related(nome = "venda")
    @Setter
    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Column(nome = "venda__fk", tipo = Long.class)
    @NotNull
    @Getter
    public Long getVendaAsLong() {
        return getRelatedAsLong(getVenda());
    }

    @Column(nome = "venda__fk", tipo = Long.class)
    @NotNull
    @Setter
    public void setVendaWithLong(Long id) {
        setVenda(setRelatedWithLong(getVenda(), id, new Venda()));
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
