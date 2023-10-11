package br.cefetmg.lagos.model.dto;

import br.cefetmg.lagos.model.dto.tipos.Permissoes;

import java.util.List;

public class Contratante extends Usuario implements DTO {
    private List<Loja> lojas;
    private ConfiguracoesDeInterface configuracoesDeInterface;
    private List<Cartao> cartoes;
    private List<ContratoAssinado> contratosAssinados;

    public Contratante() {
        super();
        super.setPermicoes(List.of(new Permissoes[]{Permissoes.CONTRATANTE}));
    }

    public void setPermicoes(List<Permissoes> permicoes) {
        throw new RuntimeException("Tipo fixo.");
    }

    public List<Loja> getLojas() {
        return lojas;
    }

    public void setLojas(List<Loja> lojas) {
        this.lojas = lojas;
    }

    public ConfiguracoesDeInterface getConfiguracoesDeInterface() {
        return configuracoesDeInterface;
    }

    public void setConfiguracoesDeInterface(ConfiguracoesDeInterface configuracoesDeInterface) {
        this.configuracoesDeInterface = configuracoesDeInterface;
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
