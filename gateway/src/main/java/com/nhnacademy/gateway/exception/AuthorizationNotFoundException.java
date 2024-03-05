package com.nhnacademy.gateway.exception;

public class AuthorizationNotFoundException extends RuntimeException{
    public AuthorizationNotFoundException(String message) {
        super(message +": Authorization not found in header");
    }
}

