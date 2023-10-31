package br.cefetmg.lagos.model.dto.base;

import br.cefetmg.lagos.model.dto.exceptions.DTOExeption;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public abstract class AbstractDTO implements DTO {
    private final Manager manager;
    private final Class<? extends AbstractDTO> thisClass;

    public AbstractDTO() {
        thisClass = this.getClass();
        manager = new Manager(this, thisClass);
    }

    protected Class<? extends AbstractDTO> getThisClass() {
        return thisClass;
    }

    public Manager getManeger() {
        return manager;
    }

    public DTO getInstance() throws DTOExeption {
        try {
            Constructor<? extends DTO> constructorDto = getThisClass().getConstructor();
            return constructorDto.newInstance();
        } catch (Exception e) {
            throw new DTOExeption(e.getMessage(), e);
        }
    }

    public String toString() {
        return getManeger().toString();
    }

    public DTO clone() {
        try {
            DTO dto = getInstance();
            Manager manager = getManeger();
            Map<String, Method> setters = manager.getSetters();

            manager.getGetters().forEach((column, getter) -> {
                Method setter = setters.get(column);
                try {
                    setter.invoke(dto, getter.invoke(this));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            });
            return dto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
