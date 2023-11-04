package br.cefetmg.lagos.model.dao.base;

import java.util.List;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;

public interface IDAO<DataTransferObject extends DTO<DataTransferObject>> {
    /**
     * Insere uma dto no banco de dados
     */
    Long inserir(DataTransferObject dto) throws PersistenceException;

    /**
     * Altera uma dto no banco de dados
     */
    boolean alterar(DataTransferObject dto) throws PersistenceException;

    /**
     * Remove uma dto do banco de dados
     */
    boolean remover(DataTransferObject dto) throws PersistenceException;

    /**
     * Lista todas as dtos correspondentes a essa dao
     */
    List<DataTransferObject> listar() throws PersistenceException;

    /**
     * Retorna a dto correspondente ao id com seus dados preenchidos
     */
    DataTransferObject consultarPorId(Long id) throws PersistenceException;

    /**
     * Retorna todas as dtos que tem algum dos ids especificados, não retorna duplicatas
     */
    List<DataTransferObject> consultarPorIdIn(Long... ids) throws PersistenceException;

    /**
     * Filtra todas as dtos que tem colunas relacionadas com a dto passada
     */
    List<DataTransferObject> filtrar(DataTransferObject dto, String... columnsFilter) throws PersistenceException;

    /**
     * Pega todas as dtos que tem uma relação da dto para a dto passada ou da dto passada para a dto
     * <br>
     * Não devem ser passadas mais de uma dto de um tipo, nem de tipos não relacionados
     */
    List<DataTransferObject> filtrarRelated(DTO... related) throws PersistenceException;

    /**
     * Pega todas as dtos que tem uma relação com qualquer uma das dtos passadas
     */
    List<DataTransferObject> filtrarRelatedIn(DTO<?>... related) throws PersistenceException;
}
