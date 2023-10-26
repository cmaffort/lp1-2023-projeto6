 package br.cefetmg.lagos.model.dto;

 import br.cefetmg.lagos.model.dto.enums.Permissao;
 import br.cefetmg.lagos.model.dto.enums.TipoUsuario;
 import br.cefetmg.lagos.model.dto.exceptions.MissingDataExeption;
 import br.cefetmg.lagos.model.dto.util.PermissoesUsuario;

 import java.util.List;

public class Usuario extends Pessoa implements DTO {
    private TipoUsuario tipo;
    private String username;
    private String senha;

    private long id;

    public List<Permissao> getPermicoes() throws MissingDataExeption {
        if (tipo == null)
            throw new MissingDataExeption("O tipo não pode ser null para pegarmos as permições.");
        return PermissoesUsuario.getPermissoesForTipo(tipo);
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

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
