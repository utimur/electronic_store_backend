package com.example.onlinestore.exceptions.notFoundException;

public class ModelNotFoundException extends RuntimeException {
    public ModelNotFoundException(String message) {
        super(message);
    }
}
