package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;

@Table(nome = "usuario_loja")
public class Caixeiro extends UsuarioLoja implements DTO {
    private Caixa caixa;

    public Caixeiro() {
        super();
        super.setTipo(TipoFuncionario.CAIXEIRO);
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
