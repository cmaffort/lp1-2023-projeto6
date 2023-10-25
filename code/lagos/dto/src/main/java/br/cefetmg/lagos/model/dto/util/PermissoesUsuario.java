package br.cefetmg.lagos.model.dto.util;

import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.enums.TipoUsuario;

import java.util.ArrayList;
import java.util.Arrays;

public class PermissoesUsuario extends PermissoesTipo {
    static {
        hm.put(TipoUsuario.GERENTE_DE_CONTRATOS, new ArrayList<>(Arrays.asList(
                Permissao.GERIR_CONTRATOS, Permissao.VISUALIZAR_CONTRATOS
        )));
        hm.put(TipoUsuario.CONTRATANTE, new ArrayList<>(Arrays.asList(
                Permissao.VISUALIZAR_CONTRATOS, Permissao.GERIR_LOJAS, Permissao.CONTRATAR_CONTRATO
        )));
    }
}
