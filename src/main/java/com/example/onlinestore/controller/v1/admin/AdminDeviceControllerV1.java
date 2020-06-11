package com.example.onlinestore.controller.v1.admin;


import com.example.onlinestore.dto.device.*;
import com.example.onlinestore.entity.device.Brand;
import com.example.onlinestore.entity.device.Device;
import com.example.onlinestore.entity.device.DeviceType;
import com.example.onlinestore.entity.device.Property;
import com.example.onlinestore.exceptions.notFoundException.BrandNotFoundException;
import com.example.onlinestore.exceptions.notFoundException.DeviceNotFoundException;
import com.example.onlinestore.exceptions.notFoundException.DeviceTypeNotFoundException;
import com.example.onlinestore.service.ImageService;
import com.example.onlinestore.service.device.BrandService;
import com.example.onlinestore.service.device.DeviceService;
import com.example.onlinestore.service.device.DeviceTypeService;
import com.example.onlinestore.service.device.PropertyService;
import com.example.onlinestore.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/admin/devices")
@CrossOrigin
public class AdminDeviceControllerV1 {

    private final UserService userService;
    private final DeviceService deviceService;
    private final DeviceTypeService deviceTypeService;
    private final BrandService brandService;
    private final PropertyService propertyService;

    public AdminDeviceControllerV1(UserService userService,
                                   DeviceService deviceService,
                                   DeviceTypeService deviceTypeService,
                                   BrandService brandService, PropertyService propertyService) {
        this.userService = userService;
        this.deviceService = deviceService;
        this.deviceTypeService = deviceTypeService;
        this.brandService = brandService;
        this.propertyService = propertyService;
    }




    @PostMapping("/type")
    public ResponseEntity<DeviceType> saveType(@RequestBody DeviceType deviceType) {
        return new ResponseEntity<>(deviceTypeService.save(deviceType), HttpStatus.OK);
    }

    @DeleteMapping("/type")
    public ResponseEntity deleteType(@RequestParam String name) throws DeviceTypeNotFoundException {
        deviceTypeService.deleteByName(name);
        return new ResponseEntity(HttpStatus.OK);
    }




    @PostMapping("/brand")
    public ResponseEntity saveBrand(@RequestBody BrandDto brandDto) throws DeviceTypeNotFoundException {
        Brand brand = BrandDto.toBrand(brandDto);
        brand.setDeviceType(deviceTypeService.getByName(brandDto.getDeviceTypeName()));
        brandService.save(brand);
        return new ResponseEntity<>(brandDto, HttpStatus.OK);
    }

    @DeleteMapping("/brand")
    public ResponseEntity deleteBrand(@RequestParam String name, @RequestParam(name = "type_name") String typeName) throws BrandNotFoundException {
        System.out.println(name + " " + typeName);
        brandService.deleteByNameAndTypeName(name, typeName);
        return new ResponseEntity( HttpStatus.OK);
    }


    @PostMapping( consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity saveDevice(@RequestParam String name,
                                             @RequestParam String brandName,
                                             @RequestParam String typeName,
                                             @RequestParam String description,
                                             @RequestParam Long price,
                                             @RequestParam MultipartFile file) throws BrandNotFoundException, IOException, DeviceTypeNotFoundException {
        Device device = new Device();
        device.setName(name);
        device.setBrand(brandService.getByNameAndTypeName(brandName, typeName));
        device.setDeviceType(deviceTypeService.getByName(typeName));
        device.setPrice(price);
        device.setDescription(description);
        device.setImage(ImageService.saveFile(file));
        deviceService.save(device);
        return new ResponseEntity<>(DeviceDto.fromDevice(device), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllDevices() throws DeviceNotFoundException {

        Map<Object, Object> response = new HashMap<>();
        response.put("devices", deviceService.getAll().stream()
                .map(DeviceDto::fromDevice).collect(Collectors.toList()));
        return new ResponseEntity( response  ,HttpStatus.OK);
    }

    @PostMapping("/property")
    public ResponseEntity saveProperty(@RequestBody PropertyDto propertyDto) throws BrandNotFoundException, IOException, DeviceTypeNotFoundException, DeviceNotFoundException {
        Device device = deviceService.getDeviceByTypeBrandDevice(
                propertyDto.getDeviceName(),
                propertyDto.getBrandName(),
                propertyDto.getTypeName() );
        if(propertyDto.getName().equals("Описание")) {
            device.setDescription(propertyDto.getDescription());
            deviceService.update(device);
            return new ResponseEntity(HttpStatus.OK);
        }
        else{
            Property property = PropertyDto.toProperty(propertyDto, device);
            return new ResponseEntity(propertyService.save(property), HttpStatus.OK);
        }
    }

}
