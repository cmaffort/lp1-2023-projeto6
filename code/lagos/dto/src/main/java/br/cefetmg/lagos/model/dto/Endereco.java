package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

@Table(nome = "endereco")
public class Endereco extends AbstractDTO<Endereco> implements DTO<Endereco> {
    private Integer cep;
    private Integer numero;

    private Long id;

    @Column(nome = "cep", tipo = Integer.class)
    @Getter
    public Integer getCep() {
        return cep;
    }

    @Column(nome = "cep", tipo = Integer.class)
    @Setter
    public void setCep(Integer cep) {
        this.cep = cep;
    }

    @Column(nome = "numero", tipo = Integer.class)
    @Getter
    public Integer getNumero() {
        return numero;
    }

    @Column(nome = "numero", tipo = Integer.class)
    @Setter
    public void setNumero(Integer numero) {
        this.numero = numero;
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
