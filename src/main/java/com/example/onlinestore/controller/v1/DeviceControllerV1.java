package com.example.onlinestore.controller.v1;


import com.example.onlinestore.dto.device.BrandDto;
import com.example.onlinestore.dto.device.DeviceDto;
import com.example.onlinestore.dto.device.DeviceTypeDto;
import com.example.onlinestore.dto.device.FullDeviceDto;
import com.example.onlinestore.entity.device.Brand;
import com.example.onlinestore.entity.device.Device;
import com.example.onlinestore.entity.device.DeviceType;
import com.example.onlinestore.exceptions.notFoundException.BrandNotFoundException;
import com.example.onlinestore.exceptions.notFoundException.DeviceNotFoundException;
import com.example.onlinestore.exceptions.notFoundException.DeviceTypeNotFoundException;
import com.example.onlinestore.service.device.BrandService;
import com.example.onlinestore.service.device.DeviceService;
import com.example.onlinestore.service.device.DeviceTypeService;
import com.example.onlinestore.service.user.UserService;
import org.hibernate.sql.OracleJoinFragment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/devices")
public class DeviceControllerV1 {

    private final UserService userService;
    private final DeviceService deviceService;
    private final DeviceTypeService deviceTypeService;
    private final BrandService brandService;

    public DeviceControllerV1(UserService userService, DeviceService deviceService, DeviceTypeService deviceTypeService, BrandService brandService) {
        this.userService = userService;
        this.deviceService = deviceService;
        this.deviceTypeService = deviceTypeService;
        this.brandService = brandService;
    }

    @GetMapping("/type")
    public ResponseEntity getTypes() throws DeviceTypeNotFoundException {
        return new ResponseEntity<>(deviceTypeService.getAll().stream()
                .map(DeviceTypeDto::fromDeviceType)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/brand")
    public ResponseEntity getBrands() throws BrandNotFoundException {
        return new ResponseEntity<>(brandService.getAll().stream()
                .map(BrandDto::fromBrand)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/brand/{id}")
    public ResponseEntity<List<Brand>> getBrandsByTypeId(@PathVariable Long id) throws BrandNotFoundException {
        return new ResponseEntity<>(brandService.getAllByDeviceTypeId(id), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity getAllDevices() throws DeviceNotFoundException {
        List<DeviceDto> devices = deviceService.getAll().stream()
                .map(DeviceDto::fromDevice)
                .collect(Collectors.toList());

        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @GetMapping("/pagination")
    public ResponseEntity getDevicesByPage(
            @RequestParam(defaultValue = "1") Long page,
            @RequestParam(defaultValue = "9") Long count,
            @RequestParam(defaultValue = "0", name = "type_id") Long typeId,
            @RequestParam(defaultValue = "0", name = "brand_id") Long brandId) throws DeviceNotFoundException {
        List<Device> devices = new ArrayList<>();
        if (brandId == 0 && typeId == 0) {
            devices = deviceService.getAll();
        }
        if (brandId == 0 && typeId != 0) {
            devices = deviceService.getAllByTypeId(typeId);
        }
        if (brandId != 0 && typeId != 0) {
            devices = deviceService.getAllByTypeIdAndBrandId(typeId, brandId);
        }
        Map<Object, Object> response = new HashMap<>();
        List<DeviceDto> deviceDtos = devices.stream().skip((page - 1) * count).limit(count).map(DeviceDto::fromDevice).collect(Collectors.toList());
        response.put("devices", deviceDtos);
        response.put("totalCount", devices.size());

        return new ResponseEntity(response, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity getDevice(@PathVariable Long id, @RequestParam("user_id") Long userId) throws DeviceNotFoundException {
        Device device = deviceService.getById(id);

        return new ResponseEntity<>(FullDeviceDto.fromDevice(device, userId), HttpStatus.OK);
    }

    @GetMapping("/{type_id}/{brand_id}")
    public ResponseEntity<List<DeviceDto>> getDevicesByBrandId(@PathVariable Long type_id,
                                                               @PathVariable Long brand_id) throws DeviceNotFoundException {
        List<DeviceDto> devices = deviceService.getAllByTypeIdAndBrandId(type_id, brand_id).stream()
                .map(DeviceDto::fromDevice)
                .collect(Collectors.toList());

        return new ResponseEntity<>( devices, HttpStatus.OK);
    }


}
