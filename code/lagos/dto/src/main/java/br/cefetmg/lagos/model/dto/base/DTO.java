package br.cefetmg.lagos.model.dto.base;

import br.cefetmg.lagos.model.dto.exceptions.DTOExeption;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public interface DTO {
    long getId();

    void setId(long id);

    Manager getManeger();

    default DTO getInstance() throws DTOExeption {
        try {
            Constructor<? extends DTO> constructorDto = getClass().getConstructor();
            return constructorDto.newInstance();
        } catch (Exception e) {
            throw new DTOExeption(e.getMessage(), e);
        }
    }

    default DTO getInstance(Map<String, Object> map) throws DTOExeption {
        DTO dto = getInstance();
        Manager manager = getManeger();
        map.forEach((column, value) -> {
            try {
                manager.getSetters().get(column).invoke(dto, value);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        });

        return dto;
    }

    default DTO getInstance(DTO dto) throws DTOExeption {
        return getInstance(dto.toMap());
    }

    DTO clone();

    Map<String, Object> toMap();

    String toString();

    default boolean equals(DTO dto) {
        return equals(dto.toMap());
    }

    default boolean equals(Map<String, Object> map) {
        return map.equals(toMap());
    }
}
