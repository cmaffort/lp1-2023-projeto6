package br.cefetmg.lagos.model.dto.contrato;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

import java.sql.Date;

@Table(nome = "contrato_assinado")
public class ContratoAssinado extends AbstractDTO<ContratoAssinado> implements DTO<ContratoAssinado> {
    private boolean vigente;
    private Date dataDeContratacao;
    private boolean cancelado;

    private Usuario usuario;
    private Contrato contrato;

    private long id;

    @Column(nome = "vigente")
    @Getter
    public boolean isVigente() {
        return vigente;
    }

    @Column(nome = "vigente")
    @Setter
    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    @Column(nome = "data_de_contratacao")
    @Getter
    public Date getDataDeContratacao() {
        return dataDeContratacao;
    }

    @Column(nome = "data_de_contratacao")
    @Setter
    public void setDataDeContratacao(Date dataDeContratacao) {
        this.dataDeContratacao = dataDeContratacao;
    }

    @Column(nome = "cancelado")
    @Getter
    public boolean isCancelado() {
        return cancelado;
    }

    @Column(nome = "cancelado")
    @Setter
    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
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

    @Column(nome = "usuario__fk")
    @Getter
    public long getUsuarioAsLong() {
        return getRelatedAsLong(getUsuario());
    }

    @Column(nome = "usuario__fk")
    @Setter
    public void setUsuarioWithLong(long id) {
        setUsuario(setRelatedWithLong(getUsuario(), id, new Usuario()));
    }

    @Related(nome = "contrato")
    @Getter
    public Contrato getContrato() {
        return contrato;
    }

    @Related(nome = "contrato")
    @Setter
    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    @Column(nome = "contrato__fk")
    @Getter
    public long getContratoAsLong() {
        return getRelatedAsLong(getContrato());
    }

    @Column(nome = "contrato__fk")
    @Setter
    public void setContratoWithLong(long id) {
        setContrato(setRelatedWithLong(getContrato(), id, new Contrato()));
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
