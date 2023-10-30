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

    private Contratante contratante;

    private long id;

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

    public Contratante getContratante() {
        return contratante;
    }

    public void setContratante(Contratante contratante) {
        this.contratante = contratante;
    }

    @Column(nome = "pk")
    @Getter
    public long getId() {
        return id;
    }

    @Column(nome = "pk")
    @Setter
    public void setId(long id) {
        this.id = id;
    }
}
