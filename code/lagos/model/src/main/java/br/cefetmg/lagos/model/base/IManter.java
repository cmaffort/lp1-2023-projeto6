package br.cefetmg.lagos.model.base;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.exception.NegocioException;

import java.util.List;

public interface IManter<DataTransferObject extends DTO<DataTransferObject>> {
    Long cadastrar(DataTransferObject dto) throws NegocioException, PersistenceException;

    boolean alterar(DataTransferObject dto) throws NegocioException, PersistenceException;

    boolean excluir(DataTransferObject dto) throws NegocioException, PersistenceException;

    List<DataTransferObject> pesquisarTodos() throws PersistenceException;

    DataTransferObject pesquisarPorId(Long id) throws PersistenceException;

    List<DataTransferObject> filtrar(DataTransferObject dto, String... columas) throws NegocioException, PersistenceException;

    List<DataTransferObject> pesquisarPorRelacionado(DTO... tabelasRelacionadas) throws NegocioException, PersistenceException;
}
