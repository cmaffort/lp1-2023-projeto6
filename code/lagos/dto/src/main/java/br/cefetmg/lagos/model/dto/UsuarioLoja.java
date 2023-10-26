package br.cefetmg.lagos.model.dto;

public abstract class UsuarioLoja extends Funcionario implements DTO {
    private String username;
    private String senha;
    // TODO: Autenticação

    private long id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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