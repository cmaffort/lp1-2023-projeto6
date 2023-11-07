package br.cefetmg.lagos.model.dao.base;

import br.cefetmg.lagos.model.dao.exceptions.PersistenceException;
import br.cefetmg.lagos.model.dao.util.JDBCOperation;
import br.cefetmg.lagos.model.dto.base.DTO;
import br.cefetmg.lagos.model.dto.base.Manager;

import java.util.List;

public abstract class InheritDAO<DataTransferObject extends DTO<DataTransferObject>, InheritDTO extends DTO<InheritDTO>>
        extends AbstractDAO<DataTransferObject> implements IDAO<DataTransferObject> {
    protected Manager<DataTransferObject> dtoManager;
    protected Manager<InheritDTO> superManager;

    public InheritDAO() {
        super();
        dtoManager = getDTO().getManeger();
        superManager = getInheritDTOInstance().getManeger();
    }

    protected abstract IDAO<InheritDTO> getSuperDAO();

    protected abstract InheritDTO getInheritDTOInstance();

    @Override
    protected List<List<String>> getColumnsPreparedStatementInserir() {
        return List.of(getDTO().getManeger().getColumns());
    }

    protected abstract InheritDTO callGetSuper(DataTransferObject dto);

    @Override
    public Long inserir(DataTransferObject dto) throws PersistenceException {
        try {
            Long id = getSuperDAO().inserir(callGetSuper(dto));
            super.inserir(dto);
            dto.setId(id);
            return id;
        } catch (Exception e) {
            throw JDBCOperation.handleExeption(e);
        }
    }

    @Override
    public boolean alterar(DataTransferObject dto) throws PersistenceException {
        try {
            getSuperDAO().alterar(callGetSuper(dto));
            return super.alterar(dto);
        } catch (Exception e) {
            throw JDBCOperation.handleExeption(e);
        }
    }

    @Override
    protected List<List<String>> getColumnsPreparedStatementRemover() {
        return List.of();
    }

    @Override
    public boolean remover(DataTransferObject dto) throws PersistenceException {
        try {
            return getSuperDAO().remover(callGetSuper(dto));
        } catch (Exception e) {
            throw JDBCOperation.handleExeption(e);
        }
    }
}
