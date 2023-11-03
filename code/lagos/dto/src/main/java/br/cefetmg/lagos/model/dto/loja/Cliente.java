package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.PessoaAdapter;
import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.sql.Date;

@Table(nome = "cliente")
public class Cliente extends AbstractDTO<Cliente> implements DTO<Cliente>, PessoaAdapter<Cliente> {
    private String instagram;
    private Date cadastro;

    private Loja loja;

    private Pessoa pessoa;

    @Column(nome = "instagram", tipo = String.class)
    @Getter
    public String getInstagram() {
        return instagram;
    }

    @Column(nome = "instagram", tipo = String.class)
    @Setter
    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    @Column(nome = "cadastro", tipo = Date.class)
    @Getter
    public Date getCadastro() {
        return cadastro;
    }

    @Column(nome = "cadastro", tipo = Date.class)
    @Setter
    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    @Related(nome = "loja")
    @Getter
    public Loja getLoja() {
        return loja;
    }

    @Related(nome = "loja")
    @Setter
    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    @Column(nome = "loja__fk", tipo = Long.class)
    @Getter
    public Long getLojaAsLong() {
        return getRelatedAsLong(getLoja());
    }

    @Column(nome = "loja__fk", tipo = Long.class)
    @Setter
    public void setLojaWithLong(Long id) {
        setRelatedWithLong(getLoja(), id, new Loja());
    }

    @Related(nome = "pessoa")
    @Getter
    public Pessoa getPessoa() {
        return pessoa;
    }

    @Related(nome = "pessoa")
    @Setter
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Column(nome = "pk", tipo = Long.class)
    @Getter
    public Long getId() {
        return getRelatedAsLong(getPessoa());
    }

    @Column(nome = "pk", tipo = Long.class)
    @Setter
    public void setId(Long id) {
        setPessoa(setRelatedWithLong(pessoa, id, new Pessoa()));
    }
}
