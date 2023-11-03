package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.PessoaAdapter;
import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.Pessoa;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.Date;

@Table(nome = "cliente")
public class Cliente extends AbstractDTO<Cliente> implements DTO<Cliente>, PessoaAdapter<Cliente> {
    private String instagram;
    private Date cadastro;

    private Loja loja;

    private Pessoa pessoa;

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

    @Column(nome = "loja__fk")
    @Getter
    public long getLojaAsLong() {
        return getRelatedAsLong(getLoja());
    }

    @Column(nome = "loja__fk")
    @Setter
    public void setLojaWithLong(long id) {
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

    @Column(nome = "pk")
    @Getter
    public long getId() {
        return getRelatedAsLong(getPessoa());
    }

    @Column(nome = "pk")
    @Setter
    public void setId(long id) {
        setPessoa(setRelatedWithLong(pessoa, id, new Pessoa()));
    }
}
