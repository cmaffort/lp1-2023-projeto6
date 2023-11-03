package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.*;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.Periodicidade;
import br.cefetmg.lagos.model.dto.base.AbstractDTO;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.util.Date;
import java.util.List;

@Table(nome = "promocao")
public class Promocao extends AbstractDTO<Promocao> implements DTO<Promocao> {
    private boolean ativa;
    private float porcentagem;
    private Date dataInicio;

    private Periodicidade periodicidade;
    private Loja loja;

    private long id;

    @Column(nome = "ativa")
    @Getter
    public boolean isAtiva() {
        return ativa;
    }

    @Column(nome = "ativa")
    @Setter
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    @Column(nome = "porcentagem")
    @Getter
    public float getPorcentagem() {
        return porcentagem;
    }

    @Column(nome = "porcentagem")
    @Getter
    public void setPorcentagem(float porcentagem) {
        this.porcentagem = porcentagem;
    }

    @Column(nome = "data_inicio")
    @Getter
    public Date getDataInicio() {
        return dataInicio;
    }

    @Column(nome = "data_inicio")
    @Setter
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Related(nome = "periodicidade")
    @Getter
    public Periodicidade getPeriodicidade() {
        return periodicidade;
    }

    @Related(nome = "periodicidade")
    @Setter
    public void setPeriodicidade(Periodicidade periodicidade) {
        this.periodicidade = periodicidade;
    }

    @Column(nome = "periodicidade__fk")
    @Getter
    public long getPeriodicidadeAsLong() {
        return getRelatedAsLong(getPeriodicidade());
    }

    @Column(nome = "periodicidade__fk")
    @Setter
    public void setPeriodicidadeWithLong(long id) {
        setPeriodicidade(setRelatedWithLong(getPeriodicidade(), id, new Periodicidade()));
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
