package br.cefetmg.lagos.model.dto.enums;

public enum TipoHistoricoVET {
    VENDA, ESTORNO, TROCA;

    public static TipoHistoricoVET get(int ord) {
        return TipoHistoricoVET.values()[ord];
    }
}
