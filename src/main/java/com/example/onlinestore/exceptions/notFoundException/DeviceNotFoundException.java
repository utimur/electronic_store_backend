package com.example.onlinestore.exceptions.notFoundException;

import javassist.NotFoundException;

public class DeviceNotFoundException extends NotFoundException {
    public DeviceNotFoundException(String msg) {
        super(msg);
    }

    public DeviceNotFoundException(String msg, Exception e) {
        super(msg, e);
    }
}
