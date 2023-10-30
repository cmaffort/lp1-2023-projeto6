package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.QueryList;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;

@Table(nome = "funcionario")
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
