package br.cefetmg.lagos.model.dto.contrato;

import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.PessoaAdapter;
import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.enums.IntEnum;
import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.enums.TipoUsuario;
import br.cefetmg.lagos.model.dto.exceptions.MissingDataExeption;
import br.cefetmg.lagos.model.dto.permicoes.PermissoesTipo;
import br.cefetmg.lagos.model.dto.permicoes.PermissoesUsuario;

import java.util.List;

@Table(nome = "usuario")
@PrimaryKey(nome = "pk")
public class Usuario extends AbstractDTO<Usuario> implements DTO<Usuario>, PessoaAdapter<Usuario> {
    private TipoUsuario tipo;
    private String username;
    private String senha;

    private Pessoa pessoa;

    public Usuario() {
        super();
        pessoa = new Pessoa();
    }

    public List<Permissao> getPermicoes() throws MissingDataExeption {
        if (tipo == null)
            throw new MissingDataExeption("O tipo não pode ser null para pegarmos as permições.");
        return PermissoesTipo.getPermissoesForTipo(tipo);
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    @Column(nome = "tipo", tipo = Integer.class)
    @NotNull
    @Getter
    public Integer getTipoAsInt() {
        return IntEnum.getIntForEnum(tipo);
    }

    @Column(nome = "tipo", tipo = Integer.class)
    @NotNull
    @Setter
    public void setTipoWithInt(Integer ord) {
        tipo = IntEnum.getEnumForInt(ord, TipoUsuario.class);
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

    @Related(nome = "pessoa")
    @Getter
    public Pessoa getPessoa() {
         return pessoa;
     }

    @Related(nome = "pessoa")
    @Setter
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
     }

    @Column(nome = "pk", tipo = Long.class)
    @NotNull
    @Getter
    public Long getId() {
        return getRelatedAsLong(pessoa);
    }

    @Column(nome = "pk", tipo = Long.class)
    @NotNull
    @Setter
    public void setId(Long id) {
        pessoa = setRelatedWithLong(pessoa, id, new Pessoa());
    }
}
