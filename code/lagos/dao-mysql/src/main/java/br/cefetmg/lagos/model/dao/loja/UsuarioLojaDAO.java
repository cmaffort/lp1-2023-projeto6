package br.cefetmg.lagos.model.dao.loja;

import br.cefetmg.lagos.model.dao.AbstractDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.loja.UsuarioLoja;

import java.util.List;

public class UsuarioLojaDAO extends AbstractDAO<UsuarioLoja> implements IUsuarioLojaDAO {
    @Override
    protected UsuarioLoja getDTO() {
        return new UsuarioLoja();
    }
}
