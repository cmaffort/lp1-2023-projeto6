package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.tipos.Permissoes;

import java.util.List;

public class GerenteDeContrato extends Usuario implements DTO {
    public GerenteDeContrato() {
        super();
        super.setPermicoes(List.of(new Permissoes[]{Permissoes.GERENTE_DE_CONTRATOS}));
    }

    public void setPermicoes(List<Permissoes> permicoes) {
        throw new RuntimeException("Tipo fixo.");
    }
}
