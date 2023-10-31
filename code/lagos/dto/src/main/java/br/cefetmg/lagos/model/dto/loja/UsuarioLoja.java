package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;

@Table(nome = "usuario_loja")
public class UsuarioLoja extends Funcionario implements DTO {
    private String username;
    private String senha;

    @Column(nome = "username")
    @Getter
    public String getUsername() {
        return username;
    }

    @Column(nome = "username")
    @Setter
    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nome = "senha")
    @Getter
    public String getSenha() {
        return senha;
    }

    @Column(nome = "senha")
    @Setter
    public void setSenha(String senha) {
        this.senha = senha;
    }
}