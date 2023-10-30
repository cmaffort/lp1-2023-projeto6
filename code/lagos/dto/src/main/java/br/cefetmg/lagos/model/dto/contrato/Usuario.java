 package br.cefetmg.lagos.model.dto.contrato;

 import br.cefetmg.lagos.model.dto.Pessoa;
 import br.cefetmg.lagos.model.dto.annotations.Column;
 import br.cefetmg.lagos.model.dto.annotations.Getter;
 import br.cefetmg.lagos.model.dto.annotations.Setter;
 import br.cefetmg.lagos.model.dto.annotations.Table;
 import br.cefetmg.lagos.model.dto.base.DTO;
 import br.cefetmg.lagos.model.dto.enums.Permissao;
 import br.cefetmg.lagos.model.dto.enums.TipoUsuario;
 import br.cefetmg.lagos.model.dto.exceptions.MissingDataExeption;
 import br.cefetmg.lagos.model.dto.permicoes.PermissoesUsuario;

 import java.sql.Date;
 import java.util.List;

 @Table(nome = "usuario")
public class Usuario extends Pessoa implements DTO {
    private TipoUsuario tipo;
    private String username;
    private String senha;

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

    @Column(nome = "tipo")
    @Getter
    public int getTipoAsInt() {
        return getTipo().ordinal();
    }

    @Column(nome = "tipo")
    @Setter
    public void setTipoWithInt(int ord) {
        setTipo(TipoUsuario.get(ord));
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
