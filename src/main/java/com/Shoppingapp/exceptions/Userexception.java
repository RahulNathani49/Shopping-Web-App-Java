package com.Shoppingapp.exceptions;
public class Userexception extends Exception{
     public Userexception(String message) {
        super(message);
    }

    public Userexception(String message, Throwable cause) {
        super(message, cause);
    }

    public Userexception(Throwable cause) {
        super(cause);
    }
}
