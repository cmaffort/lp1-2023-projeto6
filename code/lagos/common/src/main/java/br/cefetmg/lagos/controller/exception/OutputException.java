package br.cefetmg.lagos.controller.exception;

public class OutputException extends Exception {
    public OutputException(String message, Exception exception) {
        super(message, exception);
    }
}
