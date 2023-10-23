package br.cefetmg.lagos.model.dto.utils;

import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;

import java.util.ArrayList;
import java.util.Arrays;

public class PermissoesFuncionario extends PermissoesTipo {
    static {
        hm.put(TipoFuncionario.CAIXEIRO, new ArrayList<>(Arrays.asList(
                Permissao.REALIZAR_VENDA, Permissao.GERIR_CLIENTES, Permissao.OPERAR_CAIXA
        )));
        hm.put(TipoFuncionario.ESTOQUISTA, new ArrayList<>(Arrays.asList(
                Permissao.GERIR_ESTOQUE
        )));
        hm.put(TipoFuncionario.GERENTE, new ArrayList<>(Arrays.asList(
                Permissao.GERIR_COMPRAS, Permissao.GERIR_PRODUTOS, Permissao.GERIR_PROMOCOES,
                Permissao.CONFIGURAR_VENDAS, Permissao.GERIR_FUNCIONARIOS
        )));
        hm.put(TipoFuncionario.CHEFE, new ArrayList<>(Arrays.asList(
                Permissao.REALIZAR_VENDA, Permissao.GERIR_CLIENTES, Permissao.OPERAR_CAIXA,
                Permissao.GERIR_ESTOQUE, Permissao.GERIR_COMPRAS, Permissao.GERIR_PRODUTOS,
                Permissao.GERIR_PROMOCOES, Permissao.CONFIGURAR_VENDAS, Permissao.GERIR_FUNCIONARIOS,
                Permissao.GERIR_CAIXA, Permissao.GERIR_GERENTES
        )));
    }
}
