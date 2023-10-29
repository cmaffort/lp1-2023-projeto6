 package br.cefetmg.lagos.model.dto;

 import br.cefetmg.lagos.model.dto.annotations.Column;
 import br.cefetmg.lagos.model.dto.annotations.Getter;
 import br.cefetmg.lagos.model.dto.annotations.Setter;
 import br.cefetmg.lagos.model.dto.enums.Permissao;
 import br.cefetmg.lagos.model.dto.enums.TipoUsuario;
 import br.cefetmg.lagos.model.dto.exceptions.MissingDataExeption;
 import br.cefetmg.lagos.model.dto.util.PermissoesUsuario;

 import java.util.List;

public class Usuario extends Pessoa implements DTO {
    private TipoUsuario tipo;
    private String username;
    private String senha;

    public List<Permissao> getPermicoes() throws MissingDataExeption {
        if (tipo == null)
            throw new MissingDataExeption("O tipo não pode ser null para pegarmos as permições.");
        return PermissoesUsuario.getPermissoesForTipo(tipo);
    }

    public TipoUsuario getTipoUsuario() {
        return tipo;
    }

    public void setTipoUsuario(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    @Column(nome = "tipo")
    @Getter
    public int getTipo() {
        return tipo.ordinal();
    }

    @Column(nome = "tipo")
    @Setter
    public void setTipo(int ord) {
        this.tipo = TipoUsuario.values()[ord];
    }

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
