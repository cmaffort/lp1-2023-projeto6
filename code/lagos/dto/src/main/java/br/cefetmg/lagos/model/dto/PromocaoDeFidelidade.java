package br.cefetmg.lagos.model.dto;

import java.util.Date;
import java.util.List;

public class PromocaoDeFidelidade extends Promocao implements DTO {
    private Date maximoCadastro;

    private List<Venda> vendas;

    private Long id;

    public Date getMaximoCadastro() {
        return maximoCadastro;
    }

    public void setMaximoCadastro(Date maximoCadastro) {
        this.maximoCadastro = maximoCadastro;
    }

    @Override
    public List<Venda> getVendas() {
        return vendas;
    }

    @Override
    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
