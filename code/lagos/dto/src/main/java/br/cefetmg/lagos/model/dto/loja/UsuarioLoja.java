package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

@Table(nome = "usuario_loja")
public class UsuarioLoja extends AbstractDTO<UsuarioLoja> implements DTO<UsuarioLoja>, FuncionarioAdapter<UsuarioLoja> {
    private String username;
    private String senha;

    private Funcionario funcionario;

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

    @Related(nome = "funcionario")
    @Getter
    public Funcionario getFuncionario() {
        return funcionario;
    }

    @Related(nome = "funcionario")
    @Setter
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Column(nome = "pk")
    @Getter
    public long getId() {
        return getRelatedAsLong(getFuncionario());
    }

    @Column(nome = "pk")
    @Setter
    public void setId(long id) {
        setFuncionario(setRelatedWithLong(getFuncionario(), id, new Funcionario()));
    }
}