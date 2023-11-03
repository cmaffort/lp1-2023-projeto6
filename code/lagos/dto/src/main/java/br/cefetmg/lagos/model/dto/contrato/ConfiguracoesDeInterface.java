package br.cefetmg.lagos.model.dto.contrato;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

import java.io.File;
import java.sql.Blob;

@Table(nome = "configuracoes_de_interface")
public class ConfiguracoesDeInterface extends AbstractDTO<ConfiguracoesDeInterface> implements DTO<ConfiguracoesDeInterface> {
    private String nomeDaEmpresa;
    private File logo;
    private String corBase;

    private Usuario usuario;

    @Column(nome = "nome_da_empresa")
    @Getter
    public String getNomeDaEmpresa() {
        return nomeDaEmpresa;
    }

    @Column(nome = "nome_da_empresa")
    @Setter
    public void setNomeDaEmpresa(String nomeDaEmpresa) {
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    public File getLogo() {
        return logo;
    }

    public void setLogo(File logo) {
        this.logo = logo;
    }

    // TODO: Implementar parsers para blob da imagem

    @Column(nome = "logo")
    @Getter
    public Blob getLogoAsBlob() {
        return null;
    }

    @Column(nome = "logo")
    @Setter
    public void setLogoWithBlob(Blob logo) {

    }

    @Column(nome = "cor_base")
    @Getter
    public String getCorBase() {
        return corBase;
    }

    @Column(nome = "cor_base")
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

    @Column(nome = "pk")
    @Getter
    public long getId() {
        return getRelatedAsLong(getUsuario());
    }

    @Column(nome = "pk")
    @Setter
    public void setId(long id) {
        setUsuario(setRelatedWithLong(getUsuario(), id, new Usuario()));
    }
}
