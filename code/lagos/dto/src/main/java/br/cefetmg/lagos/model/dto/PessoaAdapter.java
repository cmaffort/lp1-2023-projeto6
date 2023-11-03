package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.base.DTO;

import java.sql.Date;

public interface PessoaAdapter<DataTransferObject extends PessoaAdapter<DataTransferObject>> extends DTO<DataTransferObject> {
    Pessoa getPessoa();

    void setPessoa(Pessoa pessoa);

    default String getNome() {
        return getPessoa().getNome();
    }

    default void setNome(String nome) {
        getPessoa().setNome(nome);
    }

    default String getSobrenome() {
        return getPessoa().getSobrenome();
    }

    default void setSobrenome(String sobrenome) {
        getPessoa().setSobrenome(sobrenome);
    }

    default Date getNascimento() {
        return getPessoa().getNascimento();
    }

    default void setNascimento(Date nascimento) {
        getPessoa().setNascimento(nascimento);
    }

    default String getEmail() {
        return getPessoa().getEmail();
    }

    default void setEmail(String email) {
        getPessoa().setEmail(email);
    }

    default Long getTelefone() {
        return getPessoa().getTelefone();
    }

    default void setTelefone(Long telefone) {
        getPessoa().setTelefone(telefone);
    }

    default Long getId() {
        return getPessoa().getId();
    }

    default void setId(Long id) {
        getPessoa().setId(id);
    }
}
