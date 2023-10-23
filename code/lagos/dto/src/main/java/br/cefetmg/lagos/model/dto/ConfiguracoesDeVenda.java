package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.enums.Bandeira;
import br.cefetmg.lagos.model.dto.enums.MetodosPagamento;

import java.util.List;

public class ConfiguracoesDeVenda implements DTO {
    private Float limiteDeDesconto;
    private Float taxaDeJurosEfetiva;
    private List<MetodosPagamento> metodosAceitos;
    private List<Bandeira> bandeiras;
    private Float porcentagemDeComicao;

    private Loja loja;

    private Long id;

    public Float getLimiteDeDesconto() {
        return limiteDeDesconto;
    }

    public void setLimiteDeDesconto(Float limiteDeDesconto) {
        this.limiteDeDesconto = limiteDeDesconto;
    }

    public Float getTaxaDeJurosEfetiva() {
        return taxaDeJurosEfetiva;
    }

    public void setTaxaDeJurosEfetiva(Float taxaDeJurosEfetiva) {
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

    public Float getPorcentagemDeComicao() {
        return porcentagemDeComicao;
    }

    public void setPorcentagemDeComicao(Float porcentagemDeComicao) {
        this.porcentagemDeComicao = porcentagemDeComicao;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
