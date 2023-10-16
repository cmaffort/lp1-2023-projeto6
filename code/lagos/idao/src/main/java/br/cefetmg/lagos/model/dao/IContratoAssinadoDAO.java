package br.cefetmg.lagos.model.dao;

import java.util.List;
import java.sql.SQLException;
import br.cefetmg.lagos.model.dto.ContratoAssinado;

public interface IContratoAssinadoDAO extends UsuarioDAO{
    
    boolean inserir(ContratoAssinado contratoAssinado) throws SQLException, ClassNotFoundException;
    
    boolean alterar(ContratoAssinado contratoAssinado) throws SQLException, ClassNotFoundException;
    
    boolean remover(ContratoAssinado contratoAssinado) throws SQLException, ClassNotFoundException;
    
    List<ContratoAssinado> listar() throws SQLException, ClassNotFoundException;
}
