/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.lagos.model.dao.exceptions;

/**
 *
 * @author migue
 */
public class PersistenceException extends Exception{
    public PersistenceException(String msg, Exception ex){
        super(msg, ex);
    }
}
