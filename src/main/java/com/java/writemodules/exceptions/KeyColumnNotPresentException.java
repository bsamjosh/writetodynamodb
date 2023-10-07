package com.java.writemodules.exceptions;

/**
 * Custom java exception to catch the key column exception.
 */
public class KeyColumnNotPresentException extends Exception{
    public KeyColumnNotPresentException(String message){
        super(message);
    }
}
