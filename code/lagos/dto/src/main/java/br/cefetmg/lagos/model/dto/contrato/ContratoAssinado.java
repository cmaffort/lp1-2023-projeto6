package br.cefetmg.lagos.model.dto.contrato;

import br.cefetmg.lagos.model.dto.annotations.Column;
import br.cefetmg.lagos.model.dto.annotations.Getter;
import br.cefetmg.lagos.model.dto.annotations.Setter;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;

import java.util.Date;

@Table(nome = "contrato_assinado")
public class ContratoAssinado extends AbstractDTO implements DTO {
    private boolean vigente;
    private Date dataDeContratacao;
    private boolean cancelado;

    private Contratante contratante;
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

    public Contratante getContratante() {
        return contratante;
    }

    public void setContratante(Contratante contratante) {
        this.contratante = contratante;
    }

    @Column(nome = "usuario__fk")
    @Getter
    public long getContratanteAsLong() {
        return getRelatedDTOAsLong(getContratante());
    }

    @Column(nome = "usuario__fk")
    @Setter
    public void setContratanteWithLong(long id) {
        setContratante((Contratante) setRelatedWithLong(getContratante(), id, new Contratante()));
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    @Column(nome = "contrato__fk")
    @Getter
    public long getContratoAsLong() {
        return getRelatedDTOAsLong(getContrato());
    }

    @Column(nome = "contrato__fk")
    @Setter
    public void setContratoWithLong(long id) {
        setContrato((Contrato) setRelatedWithLong(getContrato(), id, new Contrato()));
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
