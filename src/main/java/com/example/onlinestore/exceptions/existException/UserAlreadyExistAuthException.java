package com.example.onlinestore.exceptions.existException;

import org.springframework.security.core.AuthenticationException;

public class UserAlreadyExistAuthException extends AuthenticationException {
    public UserAlreadyExistAuthException(String msg) {
        super(msg);
    }
}
