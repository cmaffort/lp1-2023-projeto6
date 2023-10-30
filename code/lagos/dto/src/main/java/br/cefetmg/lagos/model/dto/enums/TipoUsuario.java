package br.cefetmg.lagos.model.dto.enums;

public enum TipoUsuario implements TipoPessoa {
    CONTRATANTE, GERENTE_DE_CONTRATOS;

    public static TipoUsuario get(int ord) {
        return TipoUsuario.values()[ord];
    }
}
