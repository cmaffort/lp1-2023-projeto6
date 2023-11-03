package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

@Table(nome = "promocoes_de_fidelidade__vendas")
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

    @Column(nome = "venda__fk")
    @Getter
    public long getVendaAsLong() {
        return getRelatedAsLong(getVenda());
    }

    @Column(nome = "venda__fk")
    @Setter
    public void setVendaWithLong(long id) {
        setVenda(setRelatedWithLong(getVenda(), id, new Venda()));
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
