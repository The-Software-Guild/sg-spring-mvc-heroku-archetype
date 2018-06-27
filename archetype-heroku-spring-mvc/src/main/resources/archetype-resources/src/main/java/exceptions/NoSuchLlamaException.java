/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ${package}.exceptions;

/**
 *
 * @author ahill
 */
public class NoSuchLlamaException extends Exception{
    
    public NoSuchLlamaException(String message) {
        super(message);
    }
    
    public NoSuchLlamaException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
