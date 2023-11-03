package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;

public class UsuarioLojaDAO extends AbstractDAO<UsuarioLoja> implements IUsuarioLojaDAO {
    @Override
    protected UsuarioLoja getDTO() {
        return new UsuarioLoja();
    }
}
