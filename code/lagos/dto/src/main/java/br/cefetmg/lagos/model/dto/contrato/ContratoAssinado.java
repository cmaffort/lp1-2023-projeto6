package br.cefetmg.lagos.model.dto.contrato;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

import java.sql.Date;

@Table(nome = "contrato_assinado")
@PrimaryKey(nome = "pk")
public class ContratoAssinado extends AbstractDTO<ContratoAssinado> implements DTO<ContratoAssinado> {
    private Date dataDeContratacao;
    private Boolean cancelado;

    private Usuario usuario;
    private Contrato contrato;

    private Long id;

    @Column(nome = "data_de_contratacao", tipo = Date.class)
    @NotNull
    @Getter
    public Date getDataDeContratacao() {
        return dataDeContratacao;
    }

    @Column(nome = "data_de_contratacao", tipo = Date.class)
    @NotNull
    @Setter
    public void setDataDeContratacao(Date dataDeContratacao) {
        this.dataDeContratacao = dataDeContratacao;
    }

    @Column(nome = "cancelado", tipo = Boolean.class)
    @NotNull
    @Getter
    public Boolean isCancelado() {
        return cancelado;
    }

    @Column(nome = "cancelado", tipo = Boolean.class)
    @NotNull
    @Setter
    public void setCancelado(Boolean cancelado) {
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

    @Column(nome = "usuario__fk", tipo = Long.class)
    @Getter
    public Long getUsuarioAsLong() {
        return getRelatedAsLong(usuario);
    }

    @Column(nome = "usuario__fk", tipo = Long.class)
    @Setter
    public void setUsuarioWithLong(Long id) {
        usuario = setRelatedWithLong(usuario, id, new Usuario());
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

    @Column(nome = "contrato__fk", tipo = Long.class)
    @NotNull
    @Getter
    public Long getContratoAsLong() {
        return getRelatedAsLong(contrato);
    }

    @Column(nome = "contrato__fk", tipo = Long.class)
    @NotNull
    @Setter
    public void setContratoWithLong(Long id) {
        contrato = setRelatedWithLong(contrato, id, new Contrato());
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
