package br.cefetmg.lagos.model.dto.contrato;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

@Table(nome = "configuracoes_de_interface")
@PrimaryKey(nome = "pk")
public class ConfiguracoesDeInterface extends AbstractDTO<ConfiguracoesDeInterface> implements DTO<ConfiguracoesDeInterface> {
    private String nomeDaEmpresa;
    private byte[] logo;
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

    @Column(nome = "logo", tipo = byte[].class)
    @Getter
    public byte[] getLogo() {
        return logo;
    }

    @Column(nome = "logo", tipo = byte[].class)
    @Setter
    public void setLogoWithBytes(byte[] logo) {
        this.logo = logo;
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
        return getRelatedAsLong(usuario);
    }

    @Column(nome = "pk", tipo = Long.class)
    @NotNull
    @Setter
    public void setId(Long id) {
        usuario = setRelatedWithLong(usuario, id, new Usuario());
    }
}
