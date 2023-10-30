package br.cefetmg.lagos.model.dto.contrato;

import br.cefetmg.lagos.model.dto.Cartao;
import br.cefetmg.lagos.model.dto.annotations.Table;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.enums.TipoUsuario;

import java.util.List;

@Table(nome = "usuario")
public class Contratante extends Usuario implements DTO {
    private List<Loja> lojas;
    private List<Cartao> cartoes;
    private List<ContratoAssinado> contratosAssinados;
    private ConfiguracoesDeInterface configuracoesDeInterface;

    public Contratante() {
        super();
        super.setTipo(TipoUsuario.CONTRATANTE);
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

    public ConfiguracoesDeInterface getConfiguracoesDeInterface() {
        return configuracoesDeInterface;
    }

    public void setConfiguracoesDeInterface(ConfiguracoesDeInterface configuracoesDeInterface) {
        this.configuracoesDeInterface = configuracoesDeInterface;
    }
}
