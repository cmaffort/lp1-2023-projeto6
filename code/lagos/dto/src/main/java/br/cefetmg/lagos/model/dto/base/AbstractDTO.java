package br.cefetmg.lagos.model.dto.base;

import java.util.List;
import java.util.Map;

public abstract class AbstractDTO<DataTransferObject extends AbstractDTO<DataTransferObject>> implements DTO<DataTransferObject> {
    protected Manager<DataTransferObject> manager;

    public AbstractDTO() {
        manager = new Manager<>((DataTransferObject) this);
    }

    public Manager<DataTransferObject> getManeger() {
        return manager;
    }

    public Map<String, Object> toMap() {
        return getManeger().toMap();
    }

    public Map<String, Object> toMap(List<String> columns) {
        return getManeger().toMap(columns);
    }

    public String toString() {
        return getManeger().toString();
    }

    public String toString(List<String> columns) {
        return getManeger().toString(columns);
    }

    protected static <DataTransferObject extends DTO<DataTransferObject>> long getRelatedAsLong(DataTransferObject related) {
        if (related == null)
            return -1;
        return related.getId();
    }

    protected static <DataTransferObject extends DTO<DataTransferObject>> DataTransferObject
    setRelatedWithLong(DataTransferObject related, long id, DataTransferObject backup) {
        if (related == null)
            related = backup;
        related.setId(id);
        return related;
    }
}
