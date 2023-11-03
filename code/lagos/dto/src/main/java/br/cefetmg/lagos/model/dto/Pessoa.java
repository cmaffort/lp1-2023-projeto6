package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

import java.sql.Date;

@Table(nome = "pessoa")
public class Pessoa extends AbstractDTO<Pessoa> implements DTO<Pessoa> {
    private String nome;
    private String sobrenome;
    private Date nascimento;
    private String email;
    private Long telefone;

    private Long id;

    @Column(nome = "nome", tipo = String.class)
    @Getter
    public String getNome() {
        return nome;
    }

    @Column(nome = "nome", tipo = String.class)
    @Setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(nome = "sobrenome", tipo = String.class)
    @Getter
    public String getSobrenome() {
        return sobrenome;
    }

    @Column(nome = "sobrenome", tipo = String.class)
    @Setter
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Column(nome = "nascimento", tipo = Date.class)
    @Getter
    public Date getNascimento() {
        return nascimento;
    }

    @Column(nome = "nascimento", tipo = Date.class)
    @Setter
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    @Column(nome = "email", tipo = String.class)
    @Getter
    public String getEmail() {
        return email;
    }

    @Column(nome = "email", tipo = String.class)
    @Setter
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nome = "telefone", tipo = Long.class)
    @Getter
    public Long getTelefone() {
        return telefone;
    }

    @Column(nome = "telefone", tipo = Long.class)
    @Setter
    public void setTelefone(Long telefone) {
        this.telefone = telefone;
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
