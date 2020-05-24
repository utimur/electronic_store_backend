package com.example.onlinestore.exceptions.existException;

public class DeviceAlreadyExist extends RuntimeException {
    public DeviceAlreadyExist(String message) {
        super(message);
    }
}
