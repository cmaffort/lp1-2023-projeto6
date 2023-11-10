package br.cefetmg.lagos.model.service.base;

import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.exception.NegocioException;

import java.util.*;
import java.util.stream.Stream;

public abstract class AbstractManter<DataTransferObject extends DTO<DataTransferObject>>
        implements IManter<DataTransferObject> {
    protected final IDAO<DataTransferObject> dao;

    protected AbstractManter() {
        dao = getDAO();
    }

    protected abstract IDAO<DataTransferObject> getDAO();

    protected abstract DataTransferObject getDTOInstance();

    protected boolean hasAllNotNullFieldsButPk(DataTransferObject dto) {
        return dto.getManeger().hasAllNotNullFieldsButPk();
    }

    protected void assertHasNotNullFieldsButPk(DataTransferObject dto) throws NegocioException {
        if (!hasAllNotNullFieldsButPk(dto))
            throw new NegocioException("A DTO deve possuir todos os campos não nulos preenchidos com algum valor.");
    }

    public Long cadastrar(DataTransferObject dto) throws NegocioException, PersistenceException {
        assertHasNotNullFieldsButPk(dto);
        return dao.inserir(dto);
    }

    protected boolean hasAllNotNullFields(DataTransferObject dto) {
        return dto.getManeger().hasAllNotNullFields();
    }

    protected void assertHasNotNullFields(DataTransferObject dto) throws NegocioException {
        if (!hasAllNotNullFields(dto))
            throw new NegocioException("A DTO deve possuir todos os campos não nulos preenchidos com algum valor.");
    }

    public boolean alterar(DataTransferObject dto) throws NegocioException, PersistenceException {
        assertHasNotNullFields(dto);
        return dao.alterar(dto);
    }

    protected boolean isIdNotNull(Long id) {
        return id != null;
    }

    protected void assertIdIsNotNull(Long id) throws NegocioException {
        if (!isIdNotNull(id))
            throw new NegocioException("O id não pode ser nulo para realizar essa operação.");
    }

    /**
     * Pode ser sobreescrito para adicionar uma implementação que excluí colunas relacionadas ou que simplesmente altera
     * a linha para que esta fique desativada, ou excluir todas que encaixem em um filtro.
     * @param dto A DTO a ser excluida
     * @return Se a DTO foi excluida.
     * @throws NegocioException Se a DTO não possuir id.
     * @throws PersistenceException Se houver um problema no banco.
     */
    public boolean excluir(DataTransferObject dto) throws NegocioException, PersistenceException {
        assertIdIsNotNull(dto.getId());
        return dao.remover(dto);
    }

    public List<DataTransferObject> pesquisarTodos() throws PersistenceException {
        return dao.listar();
    }

    public DataTransferObject pesquisarPorId(Long id) throws PersistenceException {
        return dao.consultarPorId(id);
    }

    protected <T> boolean isArrayEmpty(T[] arr) {
        return arr.length == 0;
    }

    protected <T> void assertArrayIsNotEmpty(T[] arr) throws NegocioException {
        if (isArrayEmpty(arr))
            throw new NegocioException("Ao menos um item deve ser passado");
    }

    public List<DataTransferObject> pesquisarPorIds(Long... ids) throws PersistenceException, NegocioException {
        if (ids.length == 0)
            return List.of();
        return dao.consultarPorIdIn(ids);
    }

    protected boolean areColumnsOfDTO(DataTransferObject dto, List<String> columns) {
        return (new HashSet<>(dto.getManeger().getColumns())).containsAll(columns);
    }

    protected void assertColumnsAreFromDTO(DataTransferObject dto, List<String> columns) throws NegocioException {
        if (!areColumnsOfDTO(dto, columns))
            throw new NegocioException("Ao menos uma coluna não pertence a DTO.");
    }

    public List<DataTransferObject> filtrar(DataTransferObject dto, String... columns) throws NegocioException, PersistenceException {
        if (columns.length == 0)
            return pesquisarTodos();
        assertColumnsAreFromDTO(dto, Arrays.asList(columns));
        return dao.filtrar(dto, columns);
    }

    protected boolean areAllTablesRelated(DataTransferObject dto, List<DTO> relatedTables) {
        return dto.getManeger().areAllTablesRelated(relatedTables);
    }

    protected void assertAllTablesAreRelated(DataTransferObject dto, List<DTO> relatedTables) throws NegocioException {
        if (!areAllTablesRelated(dto, relatedTables))
            throw new NegocioException("Todas as DTOs passadas devem ser relacionadas a essa DTO.");
    }

    @Override
    public List<DataTransferObject> pesquisarPorRelacionado(DTO... tabelasRelacionadas) throws NegocioException, PersistenceException {
        if (tabelasRelacionadas.length == 0)
            return pesquisarTodos();
        assertAllTablesAreRelated(getDTOInstance(), Arrays.asList(tabelasRelacionadas));
        return dao.filtrarRelated(tabelasRelacionadas);
    }

    protected boolean isTableRelated(DataTransferObject dto, DTO<?> relatedTable) {
        return dto.getManeger().isTableRelated(relatedTable);
    }

    protected void assertTableRelated(DataTransferObject dto, DTO<?> relatedTable) throws NegocioException {
        if (!isTableRelated(dto, relatedTable))
            throw new NegocioException("A DTO passada devem ser relacionada a essa DTO.");
    }

    @Override
    public List<DataTransferObject> pesquisarPorQualquerDosRelacionados(DTO<?>... tabelasRelacionadas)
            throws NegocioException, PersistenceException {
        if (tabelasRelacionadas.length == 0)
            return List.of();
        assertTableRelated(getDTOInstance(), tabelasRelacionadas[0]);
        return getDAO().filtrarRelatedIn(tabelasRelacionadas);
    }
}
