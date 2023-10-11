package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.tipos.TipoFuncionario;

public class Caixeiro extends UsuarioLoja implements DTO {
    private QueryList<Venda> vendas;
    private Caixa caixa;

    public Caixeiro() {
        super();
        super.setTipo(TipoFuncionario.CAIXEIRO);
    }

    public void setVendas(QueryList<Venda> vendas) {
        this.vendas = vendas;
    }

    public QueryList<Venda> getVendas() {
        return vendas;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    @Override
    public void setTipo(TipoFuncionario tipo) {
        throw new RuntimeException("Tipo fixo.");
    }
}
