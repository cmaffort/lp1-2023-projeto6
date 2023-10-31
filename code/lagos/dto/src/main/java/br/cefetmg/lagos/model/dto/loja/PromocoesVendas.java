package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

public class PromocoesVendas extends AbstractDTO implements DTO {
    private Promocao promocao;
    private Venda venda;

    long id;

    public Promocao getPromocaoDeFidelidade() {
        return promocao;
    }

    public void setPromocaoDeFidelidade(Promocao promocao) {
        this.promocao = promocao;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
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
