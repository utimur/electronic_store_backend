package com.example.onlinestore.exceptions.notFoundException;

import javassist.NotFoundException;

public class DeviceTypeNotFoundException extends NotFoundException {
    public DeviceTypeNotFoundException(String msg) {
        super(msg);
    }

    public DeviceTypeNotFoundException(String msg, Exception e) {
        super(msg, e);
    }
}
