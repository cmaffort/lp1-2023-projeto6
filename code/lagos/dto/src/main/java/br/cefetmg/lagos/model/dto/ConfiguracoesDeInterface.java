package br.cefetmg.lagos.model.dto;

import java.io.File;

public class ConfiguracoesDeInterface implements DTO {
    private String nomeDaEmpresa;
    private File logo;
    private String corBase;

    private Loja loja;

    private long id;

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

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
