package br.cefetmg.lagos.model.dto.base;

import br.cefetmg.lagos.model.dto.exceptions.DTOExeption;

import java.util.Map;

public abstract class AbstractDTO implements DTO {
    private final Manager manager;

    public AbstractDTO() {
        manager = new Manager(this, getClass());
    }

    public Manager getManeger() {
        return manager;
    }

    public String toString() {
        return getManeger().toString();
    }

    public Map<String, Object> toMap() {
        return getManeger().toMap();
    }

    public DTO clone() {
        try {
            return getInstance(this);
        } catch (DTOExeption e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    protected static long getRelatedDTOAsLong(DTO related) {
        if (related == null)
            return -1;
        return related.getId();
    }

    protected static DTO setRelatedWithLong(DTO related, long id, DTO backup) {
        if (related == null)
            related = backup;
        related.setId(id);
        return related;
    }

    protected static <T extends Enum<T>> int getEnumAsInt(T enumerationValue) {
        if (enumerationValue == null)
            return -1;
        return enumerationValue.ordinal();
    }
}
