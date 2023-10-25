package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;

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
