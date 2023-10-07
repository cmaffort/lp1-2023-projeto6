package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.tipos.Bandeira;

public class Cartao implements DTO {
    private long numero;
    private Bandeira bandeira;

    private Endereco endereco;
    private Loja loja;

    private long id;

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
