package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

@Table(nome = "promocoes__vendas")
@PrimaryKey(nome = "pk")
public class PromocoesVendas extends AbstractDTO<PromocoesVendas> implements DTO<PromocoesVendas> {
    private Promocao promocao;
    private Venda venda;

    long id;

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
    @NotNull
    @Getter
    public Long getPromocaoAsLong() {
        return getRelatedAsLong(getPromocao());
    }

    @Column(nome = "promocao__fk", tipo = Long.class)
    @NotNull
    @Setter
    public void setPromocaoWithLong(Long id) {
        setPromocao(setRelatedWithLong(getPromocao(), id, new Promocao()));
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
