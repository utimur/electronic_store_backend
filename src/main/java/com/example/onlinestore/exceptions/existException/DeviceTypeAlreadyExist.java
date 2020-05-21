package com.example.onlinestore.exceptions.existException;

public class DeviceTypeAlreadyExist extends RuntimeException {
    public DeviceTypeAlreadyExist(String message) {
        super(message);
    }
}
