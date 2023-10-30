package br.cefetmg.lagos.model.dto.exceptions;

public class DTOExeption extends Exception {
    public DTOExeption(String str) {
        super(str);
    }

    public DTOExeption(String str, Exception e) {
        super(str, e);
    }

    public DTOExeption(Exception e) {
        super(e);
    }
}
