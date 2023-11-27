package br.cefetmg.lagos.model.dto.base;

import br.cefetmg.lagos.model.dto.exceptions.DTOExeption;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface DTO<DataTransferObject extends DTO<DataTransferObject>> {
    Long getId();

    void setId(Long id);

    Manager<DataTransferObject> getManeger();

    @SuppressWarnings("unchecked")
    default DataTransferObject getInstance() throws DTOExeption {
        try {
            Constructor<DataTransferObject> constructorDto = (Constructor<DataTransferObject>) getClass().getConstructor();
            return constructorDto.newInstance();
        } catch (Exception e) {
            throw new DTOExeption(e.getMessage(), e);
        }
    }

    default DataTransferObject getInstance(Map<String, Object> map) throws DTOExeption {
        DataTransferObject dto = getInstance();
        Manager<DataTransferObject> manager = dto.getManeger();
        map.forEach((column, value) -> {
            try {
                manager.getSetters().get(column).invoke(dto, value);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        });

        return dto;
    }

    default DataTransferObject getInstance(DataTransferObject dto) throws DTOExeption {
        return getInstance(dto.toMap());
    }

    TreeMap<String, Object> toMap();

    TreeMap<String, Object> toMap(List<String> columns);

    String toString();

    String toString(List<String> columns);

    default boolean equals(DataTransferObject dto) {
        return equals(dto.toMap());
    }

    default boolean equals(Map<String, Object> map) {
        return map.equals(toMap());
    }
}
