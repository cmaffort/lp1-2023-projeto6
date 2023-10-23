package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;

public class Vendedor extends Funcionario implements DTO {
    private QueryList<Venda> vendas;

    public Vendedor() {
        super();
        super.setTipo(TipoFuncionario.VENDEDOR);
    }

    public void setTipo(TipoFuncionario tipo) {
        throw new RuntimeException("Tipo fixo.");
    }

    public QueryList<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(QueryList<Venda> vendas) {
        this.vendas = vendas;
    }
}
