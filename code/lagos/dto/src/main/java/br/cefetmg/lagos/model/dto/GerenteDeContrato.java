package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.enums.TipoUsuario;

import java.util.List;

public class GerenteDeContrato extends Usuario implements DTO {
    public GerenteDeContrato() {
        super();
        super.setTipo(TipoUsuario.GERENTE_DE_CONTRATOS);
    }

    public void setTipo(TipoUsuario tipo) {
        throw new RuntimeException("Tipo fixo.");
    }
}
