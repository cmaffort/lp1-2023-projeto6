package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

@Table(nome = "endereco")
public class Endereco extends AbstractDTO implements DTO {
    private int cep;
    private int numero;

    private long id;

    @Column(nome = "cep")
    @Getter
    public int getCep() {
        return cep;
    }

    @Column(nome = "cep")
    @Setter
    public void setCep(int cep) {
        this.cep = cep;
    }

    @Column(nome = "numero")
    @Getter
    public int getNumero() {
        return numero;
    }

    @Column(nome = "numero")
    @Setter
    public void setNumero(int numero) {
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
