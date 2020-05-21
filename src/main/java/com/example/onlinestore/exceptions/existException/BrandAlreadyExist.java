package com.example.onlinestore.exceptions.existException;

public class BrandAlreadyExist extends RuntimeException {
    public BrandAlreadyExist(String message) {
        super(message);
    }
}
