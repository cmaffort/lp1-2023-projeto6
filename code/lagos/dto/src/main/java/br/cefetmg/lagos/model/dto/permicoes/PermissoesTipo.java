package br.cefetmg.lagos.model.dto.permicoes;

import br.cefetmg.lagos.model.dto.enums.Permissao;
import br.cefetmg.lagos.model.dto.enums.TipoPessoa;

import java.util.HashMap;
import java.util.List;

public class PermissoesTipo {
    protected final static HashMap<TipoPessoa, List<Permissao>> hm;

    static {
        hm = new HashMap<>();
    }

    public static List<Permissao> getPermissoesForTipo(TipoPessoa tp) {
        return hm.get(tp);
    }
}
