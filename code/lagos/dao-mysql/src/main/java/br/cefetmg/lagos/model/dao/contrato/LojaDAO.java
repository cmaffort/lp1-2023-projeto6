package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dao.EnderecoDAO;
import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.util.JDBCOperation;
import br.cefetmg.lagos.model.dto.contrato.Loja;
import br.cefetmg.lagos.model.dto.contrato.Usuario;

import java.util.List;
import java.util.Map;

public class LojaDAO extends AbstractDAO<Loja> implements ILojaDAO {
    private static final EnderecoDAO ENDERECO_DAO;
    private static final UsuarioDAO USUARIO_DAO;
    
    static {
        ENDERECO_DAO = new EnderecoDAO();
        USUARIO_DAO = new UsuarioDAO();
    }
    
    @Override
    protected Loja getDTO() {
        return new Loja();
    }

    @Override
    protected Map<String, IDAO> getDAOs() {
        return Map.ofEntries(
                Map.entry("usuario", USUARIO_DAO),
                Map.entry("endereco", ENDERECO_DAO)
        );
    }

    protected List<List<String>> getColumnsPreparedStatementCountLoja() {
        return List.of(
                List.of("usuario__fk")
        );
    }

    protected List<List<String>> getColumnsResultSetCountLoja() {
        return List.of(
                List.of("COUNT(*)")
        );
    }

    protected String getSqlCountLoja() {
        return """
                SELECT COUNT(*)
                FROM loja
                WHERE usuario__fk = ?""";
    }

    public long countLojas(Usuario usuario) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = getColumnsPreparedStatementCountLoja();
        List<List<String>> columnsResultSet = getColumnsResultSetCountLoja();

        List<String> allColumnsPreparedStatement = mergeLists(columnsPreparedStatement.toArray(new List[0]));
        List<String> allColumnsResultSet = mergeLists(columnsResultSet.toArray(new List[0]));
        String sql = getSqlCountLoja();

        Loja loja = new Loja();
        loja.setUsuario(usuario);

        List<Object> result = new JDBCOperation.Builder<>(getDTO())
                .setSql(sql)
                .setColumnsPreparedStatement(allColumnsPreparedStatement, loja)
                .setColumnsResultSet(allColumnsResultSet)
                .getRow();
        if (result == null || result.isEmpty() || result.get(0) == null)
            return 0;

        return (long) result.get(0);
    }
}
