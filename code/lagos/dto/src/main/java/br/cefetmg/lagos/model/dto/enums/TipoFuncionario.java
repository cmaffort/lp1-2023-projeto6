package br.cefetmg.lagos.model.dto.enums;

public enum TipoFuncionario implements TipoPessoa {
    CAIXEIRO, VENDEDOR, CHEFE, GERENTE, ESTOQUISTA;

    public static TipoFuncionario get(int ord) {
        return TipoFuncionario.values()[ord];
    }
}
