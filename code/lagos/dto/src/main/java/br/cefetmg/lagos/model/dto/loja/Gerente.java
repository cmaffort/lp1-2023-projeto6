package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;

@Table(nome = "usuario_loja")
public class Gerente extends UsuarioLoja implements DTO {
    public Gerente() {
        super();
        super.setTipo(TipoFuncionario.GERENTE);
    }

    @Override
    public void setTipo(TipoFuncionario tipo) {
        throw new RuntimeException("Tipo fixo.");
    }
}
