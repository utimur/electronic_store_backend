package com.example.onlinestore.dto.device;

import com.example.onlinestore.entity.device.DeviceType;
import lombok.Data;

@Data
public class DeviceTypeDto {
    private Long id;
    private String name;

    public static DeviceTypeDto fromDeviceType(DeviceType deviceType) {
        DeviceTypeDto deviceTypeDto = new DeviceTypeDto();
        deviceTypeDto.setId(deviceType.getId());
        deviceTypeDto.setName(deviceType.getName());
        return deviceTypeDto;
    }
}
