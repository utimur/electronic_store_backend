package com.example.onlinestore.exceptions.notFoundException;

import javassist.NotFoundException;

public class BrandNotFoundException extends NotFoundException {
    public BrandNotFoundException(String msg) {
        super(msg);
    }
}
