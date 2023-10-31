package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

@Table(nome = "promocoes_de_fidelidade__vendas")
public class PromocoesDeFidelidadeVendas extends AbstractDTO implements DTO {
    private PromocaoDeFidelidade promocaoDeFidelidade;
    private Venda venda;

    long id;

    public PromocaoDeFidelidade getPromocaoDeFidelidade() {
        return promocaoDeFidelidade;
    }

    public void setPromocaoDeFidelidade(PromocaoDeFidelidade promocaoDeFidelidade) {
        this.promocaoDeFidelidade = promocaoDeFidelidade;
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
