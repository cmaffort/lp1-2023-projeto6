package br.cefetmg.lagos.model.dao.contrato;

import br.cefetmg.lagos.model.dao.base.AbstractDAO;
import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.util.JDBCOperation;
import br.cefetmg.lagos.model.dao.util.StringSqlDaoHelper;
import br.cefetmg.lagos.model.dto.contrato.ContratoAssinado;
import br.cefetmg.lagos.model.dto.contrato.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ContratoAssinadoDAO extends AbstractDAO<ContratoAssinado> implements IContratoAssinadoDAO {
    private static final IUsuarioDAO USUARIO_DAO;
    private static final IContratoDAO CONTRATO_DAO;

    static {
        USUARIO_DAO = new UsuarioDAO();
        CONTRATO_DAO = new ContratoDAO();
    }

    private static IUsuarioDAO getUsuarioDao() {
        return USUARIO_DAO;
    }

    private static IContratoDAO getContratoDao() {
        return CONTRATO_DAO;
    }

    @Override
    protected ContratoAssinado getDTO() {
        return new ContratoAssinado();
    }

    @Override
    protected List<String> getOrderByPriority() {
        return List.of("data_de_contratacao");
    }

    @Override
    protected Map<String, IDAO> getDAOs() {
        return Map.ofEntries(
                Map.entry("usuario", USUARIO_DAO),
                Map.entry("contrato", CONTRATO_DAO)
        );
    }

    protected List<List<String>> getColumnsPreparedStatementAssinadoAtivo() {
        return List.of(
                List.of("usuario__fk")
        );
    }

    protected List<List<String>> getColumnsResultSetAssinadoAtivo() {
        return List.of(
                Arrays.asList("data_de_contratacao", "cancelado", "usuario__fk", "contrato__fk", "pk")
        );
    }

    protected String getSqlAssinadoAtivo() {
        return """
                SELECT data_de_contratacao, cancelado, usuario__fk, contrato__fk, contrato_assinado.pk
                FROM contrato_assinado
                    INNER JOIN contrato on contrato_assinado.contrato__fk = contrato.pk
                WHERE cancelado = false and usuario__fk = ? and
                        CURDATE() <= ADDDATE(contrato_assinado.data_de_contratacao,
                                            (SELECT periodo FROM periodicidade WHERE pk = contrato.periodicidade__fk) *
                                            (SELECT quantidade_dias_por_periodo FROM periodicidade WHERE pk = contrato.periodicidade__fk))""";
    }

    public ContratoAssinado filterContratoAssinadoAtivo(Usuario usuario) throws PersistenceException {
        List<List<String>> columnsPreparedStatement = getColumnsPreparedStatementAssinadoAtivo();
        List<List<String>> columnsResultSet = getColumnsResultSetAssinadoAtivo();

        List<String> allColumnsPreparedStatement = mergeLists(columnsPreparedStatement.toArray(new List[0]));
        List<String> allColumnsResultSet = mergeLists(columnsResultSet.toArray(new List[0]));
        String sql = getSqlAssinadoAtivo();

        ContratoAssinado contratoAssinado = new ContratoAssinado();
        contratoAssinado.setUsuario(usuario);

        return fillFKedDTOs(
                new JDBCOperation.Builder<>(getDTO())
                        .setSql(sql)
                        .setColumnsPreparedStatement(allColumnsPreparedStatement, contratoAssinado)
                        .setColumnsResultSet(allColumnsResultSet)
                        .getInstance()
        );
    }
}
