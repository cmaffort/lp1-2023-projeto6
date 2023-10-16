package br.cefetmg.lagos.model.dao.exceptions;

public class PersistenceException extends Exception{
    
    public PersistenceException(String msg, Exception ex){
        super(msg, ex);
    }
    
    public PersistenceException(String msg){
        super(msg);
    }
}