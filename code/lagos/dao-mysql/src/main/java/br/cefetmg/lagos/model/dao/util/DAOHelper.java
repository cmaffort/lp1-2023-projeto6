package br.cefetmg.lagos.model.dao.util;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DAOHelper<DataTransferObject extends DTO<DataTransferObject>> {
    protected DTODb<DataTransferObject> dtoDb;
    private final DataTransferObject dto;

    public DAOHelper(DataTransferObject dto) {
        this.dto = dto;
        dtoDb = new DTODb<>(dto);
    }

    @SafeVarargs
    public static <T> List<T> mergeLists(List<T>... lists) {
        return Stream.of(lists)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public static PersistenceException handleExeption(Exception e) {
        e.printStackTrace();
        return new PersistenceException(e.getMessage(), e);
    }

    public boolean executeUpdate(DataTransferObject dto, String sql, List<String> columnsPreparedStatement) throws PersistenceException {
        try {
            JDBCOperation<DataTransferObject> operation = new JDBCOperation<>(dtoDb, sql, columnsPreparedStatement);
            operation.executeUpdate(dto);
            operation.close();

            return true;
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }

    public List<Long> executeUpdateGettingIds(List<DataTransferObject> dtos, String sql, List<String> columnsPreparedStatement)
            throws PersistenceException {
        try {
            JDBCOperation<DataTransferObject> operation = new JDBCOperation<>(dtoDb, sql, columnsPreparedStatement, Statement.RETURN_GENERATED_KEYS);
            operation.executeUpdate(dtos);

            List<Long> ids = operation.getIds();
            operation.close();

            for (int i = 0; i < ids.size(); i++)
                dtos.get(i).setId(ids.get(i));
            return ids;
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }

    public Long executeUpdateGettingId(DataTransferObject dto, String sql, List<String> columnsPreparedStatement)
            throws PersistenceException {
        try {
            JDBCOperation<DataTransferObject> operation = new JDBCOperation<>(dtoDb, sql, columnsPreparedStatement, Statement.RETURN_GENERATED_KEYS);
            operation.executeUpdate(dto);

            Long id = operation.getId();
            operation.close();
            if (id != null)
                dto.setId(id);
            return id;
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }

    private JDBCOperation<DataTransferObject> getOperationToExecuteQuery(DataTransferObject dto, String sql, List<String> columnsPreparedStatement)
            throws SQLException, ClassNotFoundException {
        if (columnsPreparedStatement == null)
            columnsPreparedStatement = List.of();

        JDBCOperation<DataTransferObject> operation = new JDBCOperation<>(dtoDb, sql, columnsPreparedStatement);

        if (dto != null)
            operation.executeQuery(dto);
        else
            operation.executeQuery();

        return operation;
    }

    public List<DataTransferObject> executeQueryGettingList(DataTransferObject dto, String sql, List<String> columnsPreparedStatement, List<String> columnsResultSet)
            throws PersistenceException {
        try {
            JDBCOperation<DataTransferObject> getDTOsOperation = getOperationToExecuteQuery(dto, sql, columnsPreparedStatement);

            List<DataTransferObject> dtosResult = getDTOsOperation.getInstances(columnsResultSet);
            getDTOsOperation.close();
            return dtosResult;
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }

    public List<DataTransferObject> executeQueryGettingList(String sql, List<String> columnsResultSet) throws PersistenceException {
        return executeQueryGettingList(null, sql, null, columnsResultSet);
    }

    public DataTransferObject executeQueryGettingDTO(DataTransferObject dto, String sql, List<String> columnsPreparedStatement, List<String> columnsResultSet)
            throws PersistenceException {
        try {
            JDBCOperation<DataTransferObject> getDTOOperation = getOperationToExecuteQuery(dto, sql, columnsPreparedStatement);

            DataTransferObject dtoResult = getDTOOperation.getInstance(columnsResultSet);
            getDTOOperation.close();
            return dtoResult;
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }

    public DataTransferObject consultarPorId(Long id, String sql, List<String> columnsPreparedStatement, List<String> columnsResultSet)
            throws PersistenceException {
        try {
            DataTransferObject dto = this.dto.getInstance();
            dto.setId(id);
            return executeQueryGettingDTO(dto, sql, columnsPreparedStatement, columnsResultSet);
        } catch (Exception e) {
            throw handleExeption(e);
        }
    }
}
