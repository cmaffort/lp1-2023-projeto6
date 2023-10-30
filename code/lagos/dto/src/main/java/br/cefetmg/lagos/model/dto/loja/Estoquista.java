package br.cefetmg.lagos.model.dto.loja;

import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;

@Table(nome = "usuario_loja")
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
