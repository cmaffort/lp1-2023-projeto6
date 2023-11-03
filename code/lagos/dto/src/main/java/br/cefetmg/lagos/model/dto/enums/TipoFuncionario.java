package br.cefetmg.lagos.model.dto.enums;

public enum TipoFuncionario implements TipoPessoa, IntEnum<TipoFuncionario> {
    CAIXEIRO, VENDEDOR, CHEFE, GERENTE, ESTOQUISTA;
}
