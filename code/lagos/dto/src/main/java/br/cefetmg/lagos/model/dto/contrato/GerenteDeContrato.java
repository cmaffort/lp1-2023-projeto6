package br.cefetmg.lagos.model.dto.contrato;

import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.enums.TipoUsuario;

@Table(nome = "usuario")
public class GerenteDeContrato extends Usuario implements DTO {
    public GerenteDeContrato() {
        super();
        super.setTipo(TipoUsuario.GERENTE_DE_CONTRATOS);
    }

    public void setTipo(TipoUsuario tipo) {
        throw new RuntimeException("Tipo fixo.");
    }
}
