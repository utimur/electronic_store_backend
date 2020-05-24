package com.example.onlinestore.dto.device;

import com.example.onlinestore.entity.device.Brand;
import com.example.onlinestore.entity.device.Device;
import lombok.Data;

@Data
public class NewDeviceDto {
    private String name;
    private Brand brand;
    private Long price;

    public static Device ToDevice(NewDeviceDto newDeviceDto) {
        Device device = new Device();
        device.setName(newDeviceDto.getName());
        device.setBrand(newDeviceDto.getBrand());
        device.setPrice(newDeviceDto.getPrice());
        return device;
    }
}
