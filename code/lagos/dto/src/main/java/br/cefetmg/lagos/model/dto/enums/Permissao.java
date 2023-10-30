package br.cefetmg.lagos.model.dto.enums;

public enum Permissao {
    GERIR_CONTRATOS, VISUALIZAR_CONTRATOS, CONTRATAR_CONTRATO, GERIR_LOJAS,  // Contratos
    GERIR_CLIENTES, REALIZAR_VENDA, OPERAR_CAIXA, GERIR_COMPRAS, GERIR_ESTOQUE, GERIR_CAIXA, GERIR_FINANCAS,
    GERIR_PRODUTOS, CONFIGURAR_VENDAS, GERIR_PROMOCOES, GERIR_FUNCIONARIOS, GERIR_GERENTES;  // Loja

    public static Permissao get(int ord) {
        return Permissao.values()[ord];
    }
}
