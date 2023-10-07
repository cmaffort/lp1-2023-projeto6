package br.cefetmg.lagos.model.dto;

import java.util.Date;
import java.util.List;

public class Cliente extends Pessoa implements DTO {
    private String instagram;
    private Date cadastro;

    private List<Venda> vendas;
    private Loja loja;

    private long id;

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}
