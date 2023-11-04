package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

@Table(nome = "caixa")
@PrimaryKey(nome = "pk")
public class Caixa extends AbstractDTO<Caixa> implements DTO<Caixa> {
    private Boolean aberto;
    private Double dinheiroEmCaixa;

    private UsuarioLoja usuarioLoja;
    private Loja loja;

    private Long id;

    @Column(nome = "aberto", tipo = Boolean.class)
    @NotNull
    @Getter
    public Boolean isAberto() {
        return aberto;
    }

    @Column(nome = "aberto", tipo = Boolean.class)
    @NotNull
    @Setter
    public void setAberto(Boolean aberto) {
        this.aberto = aberto;
    }

    @Column(nome = "dinheiro_em_caixa", tipo = Double.class)
    @NotNull
    @Getter
    public Double getDinheiroEmCaixa() {
        return dinheiroEmCaixa;
    }

    @Column(nome = "dinheiro_em_caixa", tipo = Double.class)
    @NotNull
    @Setter
    public void setDinheiroEmCaixa(Double dinheiroEmCaixa) {
        this.dinheiroEmCaixa = dinheiroEmCaixa;
    }

    @Related(nome = "usuario_loja")
    @Getter
    public UsuarioLoja getUsuarioLoja() {
        return usuarioLoja;
    }

    @Related(nome = "usuario_loja")
    @Getter
    public void setUsuarioLoja(UsuarioLoja usuarioLoja) {
        this.usuarioLoja = usuarioLoja;
    }

    @Column(nome = "usuario_loja__fk", tipo = Long.class)
    @NotNull
    @Getter
    public Long getUsuarioLojaAsLong() {
        return getRelatedAsLong(getUsuarioLoja());
    }

    @Column(nome = "usuario_loja__fk", tipo = Long.class)
    @NotNull
    @Setter
    public void setUsuarioLojaWithLong(Long id) {
        setUsuarioLoja(setRelatedWithLong(getUsuarioLoja(), id, new UsuarioLoja()));
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
    @NotNull
    @Getter
    public Long getLojaAsLong() {
        return getRelatedAsLong(getLoja());
    }

    @Column(nome = "loja__fk", tipo = Long.class)
    @NotNull
    @Setter
    public void setLojaWithLong(Long id) {
        setLoja(setRelatedWithLong(getLoja(), id, new Loja()));
    }

    @Column(nome = "pk", tipo = Long.class)
    @Getter
    public Long getId() {
        return id;
    }

    @Column(nome = "pk", tipo = Long.class)
    @Setter
    public void setId(Long id) {
        this.id = id;
    }
}
