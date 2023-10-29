package br.cefetmg.lagos.model.dto;

import java.util.List;

public class FluxoTotalDeCaixa implements DTO {
    private List<FluxoUnitarioDeCaixa> fluxosUnitarioDeCaixa;
    private Caixa caixa;
    private Loja loja;

    private long id;

    public List<FluxoUnitarioDeCaixa> getFluxosUnitarioDeCaixa() {
        return fluxosUnitarioDeCaixa;
    }

    public void setFluxosUnitarioDeCaixa(List<FluxoUnitarioDeCaixa> fluxosUnitarioDeCaixa) {
        this.fluxosUnitarioDeCaixa = fluxosUnitarioDeCaixa;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
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
