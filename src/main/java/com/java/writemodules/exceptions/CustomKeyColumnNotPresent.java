package com.java.writemodules.exceptions;

/**
 * Custom java exception to catch the key column exception.
 */
public class CustomKeyColumnNotPresent extends Exception{
    public CustomKeyColumnNotPresent(String message){
        super(message);
    }
}
