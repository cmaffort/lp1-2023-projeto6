package br.cefetmg.lagos.model.dto.contrato;

import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

import java.sql.Blob;

@Table(nome = "configuracoes_de_interface")
public class ConfiguracoesDeInterface extends AbstractDTO implements DTO {
    private String nomeDaEmpresa;
    private Blob logo;
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

    @Column(nome = "logo")
    @Getter
    public Blob getLogo() {
        return logo;
    }

    @Column(nome = "logo")
    @Setter
    public void setLogo(Blob logo) {
        this.logo = logo;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(nome = "pk")
    @Getter
    public long getId() {
        return getRelatedDTOAsLong(getUsuario());
    }

    @Column(nome = "pk")
    @Setter
    public void setId(long id) {
        setUsuario((Usuario) setRelatedWithLong(getUsuario(), id, new Usuario()));
    }
}
