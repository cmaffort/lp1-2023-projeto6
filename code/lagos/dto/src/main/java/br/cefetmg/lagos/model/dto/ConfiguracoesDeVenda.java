package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.tipos.Bandeira;
import br.cefetmg.lagos.model.dto.tipos.MetodosPagamento;

import java.util.List;

public class ConfiguracoesDeVenda implements DTO {
    private float limiteDeDesconto;
    private float taxaDeJurosEfetiva;
    private List<MetodosPagamento> metodosAceitos;
    private List<Bandeira> bandeiras;

    private List<Promocao> promocoes;
    private Loja loja;

    private long id;

    public float getLimiteDeDesconto() {
        return limiteDeDesconto;
    }

    public void setLimiteDeDesconto(float limiteDeDesconto) {
        this.limiteDeDesconto = limiteDeDesconto;
    }

    public float getTaxaDeJurosEfetiva() {
        return taxaDeJurosEfetiva;
    }

    public void setTaxaDeJurosEfetiva(float taxaDeJurosEfetiva) {
        this.taxaDeJurosEfetiva = taxaDeJurosEfetiva;
    }

    public List<MetodosPagamento> getMetodosAceitos() {
        return metodosAceitos;
    }

    public void setMetodosAceitos(List<MetodosPagamento> metodosAceitos) {
        this.metodosAceitos = metodosAceitos;
    }

    public List<Bandeira> getBandeiras() {
        return bandeiras;
    }

    public void setBandeiras(List<Bandeira> bandeiras) {
        this.bandeiras = bandeiras;
    }

    public List<Promocao> getPromocoes() {
        return promocoes;
    }

    public void setPromocoes(List<Promocao> promocoes) {
        this.promocoes = promocoes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
