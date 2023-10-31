package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.Date;

@Table(nome = "cliente")
public class Cliente extends Pessoa implements DTO {
    private String instagram;
    private Date cadastro;

    private Loja loja;

    @Column(nome = "instagram")
    @Getter
    public String getInstagram() {
        return instagram;
    }

    @Column(nome = "instagram")
    @Setter
    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    @Column(nome = "cadastro")
    @Getter
    public Date getCadastro() {
        return cadastro;
    }

    @Column(nome = "cadastro")
    @Setter
    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
}
