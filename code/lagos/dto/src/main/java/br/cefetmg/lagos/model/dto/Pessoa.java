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
    private long telefone;

    private long id;

    @Column(nome = "nome")
    @Getter
    public String getNome() {
        return nome;
    }

    @Column(nome = "nome")
    @Setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(nome = "sobrenome")
    @Getter
    public String getSobrenome() {
        return sobrenome;
    }

    @Column(nome = "sobrenome")
    @Setter
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Column(nome = "nascimento")
    @Getter
    public Date getNascimento() {
        return nascimento;
    }

    @Column(nome = "nascimento")
    @Setter
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    @Column(nome = "email")
    @Getter
    public String getEmail() {
        return email;
    }

    @Column(nome = "email")
    @Setter
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nome = "telefone")
    @Getter
    public long getTelefone() {
        return telefone;
    }

    @Column(nome = "telefone")
    @Setter
    public void setTelefone(long telefone) {
        this.telefone = telefone;
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

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Pessoa");
    }
}
