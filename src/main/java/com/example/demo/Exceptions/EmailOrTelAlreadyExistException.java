package com.example.demo.Exceptions;

public class EmailOrTelAlreadyExistException extends RuntimeException {
    public EmailOrTelAlreadyExistException(String message) {
        super(message);
    }
}
