package br.cefetmg.lagos.model.exception;

public class NegocioException extends Exception {

    public NegocioException(String msg, Exception ex) {
        super(msg, ex);
    }

    public NegocioException(String msg) {
        super(msg);
    }
}
