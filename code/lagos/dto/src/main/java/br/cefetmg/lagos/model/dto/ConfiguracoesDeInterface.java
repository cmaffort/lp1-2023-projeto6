package br.cefetmg.lagos.model.dto;

import java.io.File;

public class ConfiguracoesDeInterface implements DTO {
    private String nomeDaEmpresa;
    private File logo;
    private String corBase;

    private Contratante contratante;

    private Long id;

    public String getNomeDaEmpresa() {
        return nomeDaEmpresa;
    }

    public void setNomeDaEmpresa(String nomeDaEmpresa) {
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    public File getLogo() {
        return logo;
    }

    public void setLogo(File logo) {
        this.logo = logo;
    }

    public String getCorBase() {
        return corBase;
    }

    public void setCorBase(String corBase) {
        this.corBase = corBase;
    }

    public Contratante getContratante() {
        return contratante;
    }

    public void setContratante(Contratante contratante) {
        this.contratante = contratante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
