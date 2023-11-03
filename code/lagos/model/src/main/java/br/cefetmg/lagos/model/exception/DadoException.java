package br.cefetmg.lagos.model.exception;

public class DadoException extends Exception{
    
    public DadoException(String msg, Exception ex){
        super(msg, ex);
    }
    
    public DadoException(String msg){
        super(msg);
    }
}
