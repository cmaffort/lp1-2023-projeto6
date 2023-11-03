package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

@Table(nome = "caixa")
public class Caixa extends AbstractDTO<Caixa> implements DTO<Caixa> {
    private boolean aberto;
    private double dinheiroEmCaixa;

    private UsuarioLoja usuarioLoja;
    private Loja loja;

    private long id;

    @Column(nome = "aberto")
    @Getter
    public boolean isAberto() {
        return aberto;
    }

    @Column(nome = "aberto")
    @Setter
    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    @Column(nome = "dinheiro_em_caixa")
    @Getter
    public double getDinheiroEmCaixa() {
        return dinheiroEmCaixa;
    }

    @Column(nome = "dinheiro_em_caixa")
    @Setter
    public void setDinheiroEmCaixa(double dinheiroEmCaixa) {
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

    @Column(nome = "usuario_loja__fk")
    @Getter
    public long getUsuarioLojaAsLong() {
        return getRelatedAsLong(getUsuarioLoja());
    }

    @Column(nome = "usuario_loja__fk")
    @Setter
    public void setUsuarioLojaWithLong(long id) {
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

    @Column(nome = "loja__fk")
    @Getter
    public long getLojaAsLong() {
        return getRelatedAsLong(getLoja());
    }

    @Column(nome = "loja__fk")
    @Setter
    public void setLojaWithLong(long id) {
        setLoja(setRelatedWithLong(getLoja(), id, new Loja()));
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
