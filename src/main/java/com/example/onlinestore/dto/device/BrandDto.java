package com.example.onlinestore.dto.device;

import com.example.onlinestore.entity.device.Brand;
import com.example.onlinestore.exceptions.notFoundException.DeviceTypeNotFoundException;
import com.example.onlinestore.service.device.BrandService;
import com.example.onlinestore.service.device.DeviceTypeService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.Transient;

@Data
public class BrandDto {
    private Long id;
    private String name;
    private String deviceTypeName;
    private Long typeId;

    public static Brand toBrand(BrandDto brandDto) throws DeviceTypeNotFoundException {
        Brand brand = new Brand();
        brand.setName(brandDto.getName());
        return brand;
    }

    public static BrandDto fromBrand(Brand brand) {
        BrandDto brandDto = new BrandDto();
        brandDto.setId(brand.getId());
        brandDto.setName(brand.getName());
        brandDto.setDeviceTypeName(brand.getDeviceType().getName());
        brandDto.setTypeId(brand.getDeviceType().getId());
        return brandDto;
    }
}
