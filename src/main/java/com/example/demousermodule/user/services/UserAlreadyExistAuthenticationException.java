package com.example.demousermodule.user.services;

public class UserAlreadyExistAuthenticationException extends Exception {

    public UserAlreadyExistAuthenticationException(final String msg) {
        super(msg);
    }

}
