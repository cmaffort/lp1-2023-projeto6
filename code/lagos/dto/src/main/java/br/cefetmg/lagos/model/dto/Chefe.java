package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.tipos.TipoFuncionario;

public class Chefe extends UsuarioLoja implements DTO {
    public Chefe() {
        super();
        super.setTipo(TipoFuncionario.CHEFE);
    }

    @Override
    public void setTipo(TipoFuncionario tipo) {
        throw new RuntimeException("Tipo fixo.");
    }

}