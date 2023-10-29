package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.enums.TipoUsuario;

import java.util.List;

public class Contratante extends Usuario implements DTO {
    private List<Loja> lojas;
    private List<Cartao> cartoes;
    private List<ContratoAssinado> contratosAssinados;

    public Contratante() {
        super();
        super.setTipoUsuario(TipoUsuario.CONTRATANTE);
    }

    public void setTipo(TipoUsuario tipo) {
        throw new RuntimeException("Tipo fixo.");
    }

    public List<Loja> getLojas() {
        return lojas;
    }

    public void setLojas(List<Loja> lojas) {
        this.lojas = lojas;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    public List<ContratoAssinado> getContratosAssinados() {
        return contratosAssinados;
    }

    public void setContratosAssinados(List<ContratoAssinado> contratosAssinados) {
        this.contratosAssinados = contratosAssinados;
    }
}
