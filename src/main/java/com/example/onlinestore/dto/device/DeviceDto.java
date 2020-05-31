package com.example.onlinestore.dto.device;

import com.example.onlinestore.entity.device.Device;
import com.example.onlinestore.service.ImageService;
import lombok.Data;

import java.io.File;

@Data
public class DeviceDto {
    private Long id;
    private String name;
    private Long brandId;
    private Long price;
    private Float rating;
    private String image;


    public static DeviceDto fromDevice(Device device) {
        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setId(device.getId());
        deviceDto.setName(device.getName());
        deviceDto.setBrandId(device.getBrand().getId());
        deviceDto.setPrice(device.getPrice());
        deviceDto.setRating(device.getRating());

        if (device.getImage() != null) {
            String imgPath = ImageService.IMAGE_PATH + device.getImage();
            File file = new File(imgPath);
            if(file.exists()) {
                deviceDto.setImage(ImageService.encodeFileToBase64Binary(file));
            }
        }
       return deviceDto;
    }
}