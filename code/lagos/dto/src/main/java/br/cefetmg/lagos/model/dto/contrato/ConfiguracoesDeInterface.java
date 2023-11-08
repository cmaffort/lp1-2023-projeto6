package br.cefetmg.lagos.model.dto.contrato;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.util.Blober;

import java.io.File;
import java.sql.Blob;

@Table(nome = "configuracoes_de_interface")
@PrimaryKey(nome = "pk")
public class ConfiguracoesDeInterface extends AbstractDTO<ConfiguracoesDeInterface> implements DTO<ConfiguracoesDeInterface> {
    private String nomeDaEmpresa;
    private File logo;
    private String corBase;

    private Usuario usuario;

    @Column(nome = "nome_da_empresa", tipo = String.class)
    @Getter
    public String getNomeDaEmpresa() {
        return nomeDaEmpresa;
    }

    @Column(nome = "nome_da_empresa", tipo = String.class)
    @Setter
    public void setNomeDaEmpresa(String nomeDaEmpresa) {
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    public File getLogo() {
        return logo;
    }

    public void setLogo(File logo) {
        this.logo = logo;
        this.logo.deleteOnExit();
    }

    @Column(nome = "logo", tipo = Blob.class)
    @Getter
    public Blob getLogoAsBlob() {
        try {
            return Blober.parseFromFile(logo);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Column(nome = "logo", tipo = Blob.class)
    @Setter
    public void setLogoWithBlob(Blob logo) {
        try {
            this.logo = Blober.parseToFile(logo, ".png");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Column(nome = "cor_base", tipo = String.class)
    @Getter
    public String getCorBase() {
        return corBase;
    }

    @Column(nome = "cor_base", tipo = String.class)
    @Setter
    public void setCorBase(String corBase) {
        this.corBase = corBase;
    }

    @Related(nome = "usuario")
    @Getter
    public Usuario getUsuario() {
        return usuario;
    }

    @Related(nome = "usuario")
    @Setter
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(nome = "pk", tipo = Long.class)
    @NotNull
    @Getter
    public Long getId() {
        return getRelatedAsLong(getUsuario());
    }

    @Column(nome = "pk", tipo = Long.class)
    @NotNull
    @Setter
    public void setId(Long id) {
        setUsuario(setRelatedWithLong(getUsuario(), id, new Usuario()));
    }
}
