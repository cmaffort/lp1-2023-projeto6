package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.annotations.*;

public class Endereco implements DTO {
    private Integer cep;
    private Integer numero;

    private long id;

    @Column(nome = "cep")
    @Getter
    public Integer getCep() {
        return cep;
    }

    @Column(nome = "cep")
    @Setter
    public void setCep(Integer cep) {
        this.cep = cep;
    }

    @Column(nome = "numero")
    @Getter
    public Integer getNumero() {
        return numero;
    }

    @Column(nome = "numero")
    @Setter
    public void setNumero(Integer numero) {
        this.numero = numero;
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
