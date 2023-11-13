package br.cefetmg.lagos.model.dto.permicoes;

import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.enums.TipoFuncionario;
import br.cefetmg.lagos.model.dto.enums.TipoPessoa;
import br.cefetmg.lagos.model.dto.enums.TipoUsuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PermissoesTipo {
    protected static final HashMap<TipoPessoa, List<Permissao>> hm;

    static {
        hm = new HashMap<>();
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
        hm.put(TipoUsuario.GERENTE_DE_CONTRATOS, new ArrayList<>(Arrays.asList(
                Permissao.GERIR_CONTRATOS, Permissao.VISUALIZAR_CONTRATOS
        )));
        hm.put(TipoUsuario.CONTRATANTE, new ArrayList<>(Arrays.asList(
                Permissao.VISUALIZAR_CONTRATOS, Permissao.GERIR_LOJAS, Permissao.CONTRATAR_CONTRATO
        )));
    }

    public static List<Permissao> getPermissoesForTipo(TipoPessoa tp) {
        return hm.get(tp);
    }
}
