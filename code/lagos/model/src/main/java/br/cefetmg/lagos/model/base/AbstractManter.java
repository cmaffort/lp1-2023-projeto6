package br.cefetmg.lagos.model.base;

import br.cefetmg.lagos.model.dao.base.IDAO;
import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.exception.NegocioException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public abstract class AbstractManter<DataTransferObject extends DTO<DataTransferObject>>
        implements IManter<DataTransferObject> {
    protected final IDAO<DataTransferObject> dao;

    public AbstractManter() {
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
        if (!hasAllNotNullFieldsButPk(dto))
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

    public List<DataTransferObject> pesquisarPorIds(Long... ids) throws PersistenceException {
        return dao.consultarPorIdIn(ids);
    }

    protected boolean areColumnsOfDTO(DataTransferObject dto, List<String> columns) {
        return Collections.indexOfSubList(dto.getManeger().getColumns(), columns) != -1;
    }

    protected void assertColumnsAreFromDTO(DataTransferObject dto, List<String> columns) throws NegocioException {
        if (!areColumnsOfDTO(dto, columns))
            throw new NegocioException("Ao menos uma coluna não pertence a DTO.");
    }

    public List<DataTransferObject> filtrar(DataTransferObject dto, String... columas) throws NegocioException, PersistenceException {
        assertColumnsAreFromDTO(dto, Arrays.asList(columas));
        return dao.filtrar(dto, columas);
    }

    protected boolean areAllTablesRelated(DataTransferObject dto, List<DTO> relatedTables) {
        List<String> relatedTablesNames = relatedTables.stream()
                .map(dtoRelated -> dtoRelated.getManeger().getTable()).toList();

        List<String> otherSideRelated = relatedTables.stream()
                .map(related -> (List<String>) related.getManeger().getRelatedTables())
                .flatMap(Collection::stream).toList();

        List<String> allRelations = Stream.concat(dto.getManeger().getRelatedTables().stream(), otherSideRelated.stream()).toList();

        return Collections.indexOfSubList(allRelations, relatedTablesNames) != -1;
    }

    protected void assertAllTablesAreRelated(DataTransferObject dto, List<DTO> relatedTables) throws NegocioException {
        if (!areAllTablesRelated(dto, relatedTables))
            throw new NegocioException("Todas as DTOs passadas devem ser relacionadas a essa DTO.");
    }

    public List<DataTransferObject> pesquisarPorRelacionado(DTO... tabelasRelacionadas) throws NegocioException, PersistenceException {
        assertAllTablesAreRelated(getDTOInstance(), Arrays.asList(tabelasRelacionadas));
        return dao.filtrarRelated(tabelasRelacionadas);
    }

    protected List<? extends DTO<?>> pesquisarRelacionados(DataTransferObject dto, IManter<? extends DTO<?>> daoRelacionado) throws NegocioException, PersistenceException {
        try {
            return daoRelacionado.pesquisarPorRelacionado(dto);
        } catch (NegocioException negocioException) {
            throw new NegocioException("As DTOs não são relacionadas.");
        }
    }
}
