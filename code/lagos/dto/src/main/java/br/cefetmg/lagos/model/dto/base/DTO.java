package br.cefetmg.lagos.model.dto.base;

import br.cefetmg.lagos.model.dto.exceptions.DTOExeption;

public interface DTO {
    long getId();

    void setId(long id);

    Manager getManeger();

    DTO getInstance() throws DTOExeption;

    DTO clone();
}
