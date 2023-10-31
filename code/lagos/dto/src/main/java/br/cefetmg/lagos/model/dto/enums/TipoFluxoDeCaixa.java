package br.cefetmg.lagos.model.dto.enums;

public enum TipoFluxoDeCaixa {
    CRIAR_CAIXA, MOVIMENTAR_DINHEIRO, INSERIR_DINHEIRO;

    public static TipoFluxoDeCaixa get(int ord) {
        return TipoFluxoDeCaixa.values()[ord];
    }
}
