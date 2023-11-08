package br.cefetmg.lagos.model.dto.base;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class AbstractDTO<DataTransferObject extends AbstractDTO<DataTransferObject>> implements DTO<DataTransferObject> {
    protected Manager<DataTransferObject> manager;

    protected AbstractDTO() {
        manager = new Manager<>((DataTransferObject) this);
    }

    public Manager<DataTransferObject> getManeger() {
        return manager;
    }

    public TreeMap<String, Object> toMap() {
        return manager.toMap();
    }

    public TreeMap<String, Object> toMap(List<String> columns) {
        return manager.toMap(columns);
    }

    public String toString() {
        return manager.toString();
    }

    public String toString(List<String> columns) {
        return manager.toString(columns);
    }

    protected static <DataTransferObject extends DTO<DataTransferObject>> Long getRelatedAsLong(DataTransferObject related) {
        if (related != null)
            return related.getId();
        return null;
    }

    protected static <DataTransferObject extends DTO<DataTransferObject>> DataTransferObject
    setRelatedWithLong(DataTransferObject related, Long id, DataTransferObject backup) {
        if (related == null)
            related = backup;
        related.setId(id);
        return related;
    }
}
