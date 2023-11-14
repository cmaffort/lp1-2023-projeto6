package br.cefetmg.lagos.controller.util.exception;

public class InputException extends Exception {
    public InputException(String message, Exception exception) {
        super(message, exception);
    }
}
