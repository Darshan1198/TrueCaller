package com.truecaller.exception;

public class ContactNotFoundException extends RuntimeException {

    public ContactNotFoundException(String message)
    {
        super(message);
    }
}
