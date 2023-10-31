package br.cefetmg.lagos.model.dto.enums;

public enum Bandeira {
    VISA, MASTERCARD;
    // Todas as bandeiras que o sistema pode suportar

    public static Bandeira get(int ord) {
        return Bandeira.values()[ord];
    }
}
