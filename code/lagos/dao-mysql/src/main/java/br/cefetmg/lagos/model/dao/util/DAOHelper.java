package br.cefetmg.lagos.model.dao.util;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DAOHelper {
    protected DTODb dtoDb;
    private final DTO dto;

    public DAOHelper(DTO dto) {
        this.dto = dto;
        dtoDb = new DTODb(dto);
    }

    @SafeVarargs
    public final <T> List<T> mergeLists(List<T>... lists) {
        return Stream.of(lists)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public PersistenceException handleExeption(Exception e) {
        e.printStackTrace();
        return new PersistenceException(e.getMessage(), e);
    }

    public boolean executeSql(DTO dto, String sql, List<String> columnsPreparedStatement)
            throws SQLException, ClassNotFoundException {
        JDBCOperation operation = new JDBCOperation(dtoDb, sql, columnsPreparedStatement);
        operation.executeUpdate(dto);

        operation.close();

        return true;
    }

    public List<Long> inserirVarios(List<DTO> dtos, String sql, List<String> columnsPreparedStatement)
            throws PersistenceException {
        try {
            JDBCOperation inserirVariosOperation =
                    new JDBCOperation(dtoDb, sql, columnsPreparedStatement,Statement.RETURN_GENERATED_KEYS);
            inserirVariosOperation.executeUpdate(dtos);
            List<Long> ids = inserirVariosOperation.getIds();
            for (int i = 0; i < ids.size(); i++)
                dtos.get(i).setId(ids.get(i));
            return ids;
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }

    public Long inserir(DTO dto, String sql, List<String> columnsPreparedStatement)
            throws PersistenceException {
        try {
            JDBCOperation inserirOperation =
                    new JDBCOperation(dtoDb, sql, columnsPreparedStatement, Statement.RETURN_GENERATED_KEYS);
            inserirOperation.executeUpdate(dto);
            Long id = inserirOperation.getId();
            if (id != null)
                dto.setId(id);
            inserirOperation.close();
            return id;
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }

    public boolean alterar(DTO dto, String sql, List<String> columnsPreparedStatement)
            throws PersistenceException {
        try {
            return executeSql(dto, sql, columnsPreparedStatement);
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }

    public boolean remover(DTO dto, String sql, List<String> columnsPreparedStatement) throws PersistenceException {
        try {
            return executeSql(dto, sql, columnsPreparedStatement);
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }

    public List<? extends DTO> listar(String sql, List<String> columnsResultSet) throws PersistenceException {
        try {
            JDBCOperation listarOperation = new JDBCOperation(dtoDb, sql, List.of());
            listarOperation.executeQuery();
            return listarOperation.getInstances(columnsResultSet);
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }

    public DTO consultarPor(String sql, List<String> columnsResultSet)
            throws PersistenceException {
        try {
            JDBCOperation consultarOperation = new JDBCOperation(dtoDb, sql, List.of());
            consultarOperation.executeQuery();
            return consultarOperation.getInstance(columnsResultSet);
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }

    public DTO consultarPorId(Long id, String sql, List<String> columnsPreparedStatement, List<String> columnsResultSet)
            throws PersistenceException {
        try {
            JDBCOperation consultarOperation = new JDBCOperation(dtoDb, sql, columnsPreparedStatement);
            DTO dto = this.dto.getInstance();
            dto.setId(id);
            consultarOperation.executeQuery(dto);
            return consultarOperation.getInstance(columnsResultSet);
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }
}
