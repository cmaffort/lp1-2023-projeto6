package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.exceptions.MissingDataExeption;
import br.cefetmg.lagos.model.dto.permicoes.PermissoesTipo;

import java.util.List;

@Table(nome = "usuario_loja")
@PrimaryKey(nome = "pk")
public class UsuarioLoja extends AbstractDTO<UsuarioLoja> implements DTO<UsuarioLoja>, FuncionarioAdapter<UsuarioLoja> {
    private String username;
    private String senha;

    private Funcionario funcionario;

    public UsuarioLoja() {
        super();
        funcionario = new Funcionario();
    }

    public List<Permissao> getPermicoes() throws MissingDataExeption {
        if (getTipo() == null)
            throw new MissingDataExeption("O tipo não pode ser null para pegarmos as permições.");
        return PermissoesTipo.getPermissoesForTipo(getTipo());
    }

    @Column(nome = "username", tipo = String.class)
    @NotNull
    @Getter
    public String getUsername() {
        return username;
    }

    @Column(nome = "username", tipo = String.class)
    @NotNull
    @Setter
    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nome = "senha", tipo = String.class)
    @NotNull
    @Getter
    public String getSenha() {
        return senha;
    }

    @Column(nome = "senha", tipo = String.class)
    @NotNull
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

    @Column(nome = "pk", tipo = Long.class)
    @NotNull
    @Getter
    public Long getId() {
        return getRelatedAsLong(funcionario);
    }

    @Column(nome = "pk", tipo = Long.class)
    @NotNull
    @Setter
    public void setId(Long id) {
        funcionario = setRelatedWithLong(funcionario, id, new Funcionario());
    }
}