package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.tipos.TipoFuncionario;

public class Estoquista extends UsuarioLoja implements DTO {
    public Estoquista() {
        super();
        super.setTipo(TipoFuncionario.ESTOQUISTA);
    }

    @Override
    public void setTipo(TipoFuncionario tipo) {
        throw new RuntimeException("Tipo fixo.");
    }
}
