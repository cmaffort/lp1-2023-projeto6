package br.cefetmg.lagos.model.dto.enums;

public enum MetodosPagamento {
    DINHEIRO, PIX, DEBITO, CREDITO;

    public static MetodosPagamento get(int ord) {
        return MetodosPagamento.values()[ord];
    }
}
