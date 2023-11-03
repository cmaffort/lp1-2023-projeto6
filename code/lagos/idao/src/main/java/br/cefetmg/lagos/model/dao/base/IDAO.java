package br.cefetmg.lagos.model.dao.base;

import java.util.List;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;

public interface IDAO<DataTransferObject extends DTO<DataTransferObject>> {
    Long inserir(DataTransferObject dto) throws PersistenceException;

    boolean alterar(DataTransferObject dto) throws PersistenceException;

    boolean remover(DataTransferObject pessoa) throws PersistenceException;

    List<DataTransferObject> listar() throws PersistenceException;

    DataTransferObject consultarPorId(Long id) throws PersistenceException;

    /**
     * Pega todas as dtos que passarem no filtro de uma outra dto do mesmo tipo.
     * @param dto A dto a ser usada como filtro.
     * @param columnsFilter As colunas que serão usadas para realizar o filtro.
     * @return As dtos que passaram no filtro.
     * @throws PersistenceException Se a dto passada não possuir alguma coluna passada, ou se ocorrer um erro no banco.
     */
    List<DataTransferObject> filtrar(DataTransferObject dto, String... columnsFilter) throws PersistenceException;

    /**
     * Pega todas as dtos que tiverem uma relação de foreing key com as dtos passadas. <br>
     * Esse método só funciona para relações diretas entre duas tabelas.
     * @param related A ou as dtos pelas quais quer se filtrar.
     * @return As dtos relacionadas as passadas.
     * @throws PersistenceException Se alguma das dtos passadas não for relacionada com a dessa classe no banco de dados.
     */
    List<DataTransferObject> filtrarRelated(DTO... related) throws PersistenceException;
}
