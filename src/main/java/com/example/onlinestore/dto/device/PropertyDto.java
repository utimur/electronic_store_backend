package com.example.onlinestore.dto.device;

import com.example.onlinestore.entity.device.Device;
import com.example.onlinestore.entity.device.Property;
import lombok.Data;

@Data
public class PropertyDto {
    private String id;
    private String typeName;
    private String brandName;
    private String deviceName;
    private String name;
    private String description;

    public static Property toProperty(PropertyDto propertyDto, Device device) {
        Property property = new Property();
        property.setName(propertyDto.getName());
        property.setDescription(propertyDto.getDescription());
        property.setDevice(device);
        return property;
    }
}
