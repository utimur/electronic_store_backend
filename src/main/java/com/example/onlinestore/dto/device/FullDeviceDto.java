package com.example.onlinestore.dto.device;


import com.example.onlinestore.entity.device.Comment;
import com.example.onlinestore.entity.device.Device;
import com.example.onlinestore.entity.device.Property;
import com.example.onlinestore.service.ImageService;
import lombok.Data;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class FullDeviceDto extends DeviceDto{

    private List<Property> properties;

    private List<CommentDto> comments;


    public static FullDeviceDto fromDevice(Device device) {
        FullDeviceDto deviceDto = new FullDeviceDto();
        deviceDto.setId(device.getId());
        deviceDto.setName(device.getName());
        deviceDto.setBrandId(device.getBrand().getId());
        deviceDto.setTypeId(device.getDeviceType().getId());
        deviceDto.setPrice(device.getPrice());
        deviceDto.setRating(device.getRating());
        deviceDto.setBrandName(device.getBrand().getName());
        deviceDto.setTypeName(device.getDeviceType().getName());
        deviceDto.setDescription(device.getDescription());
        deviceDto.setComments(device.getComments().stream().map(CommentDto::fromComment).collect(Collectors.toList()));
        deviceDto.setProperties(device.getProperties());
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
