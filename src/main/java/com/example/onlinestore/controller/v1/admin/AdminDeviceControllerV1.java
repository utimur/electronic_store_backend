package com.example.onlinestore.controller.v1.admin;


import com.example.onlinestore.dto.device.NewDeviceDto;
import com.example.onlinestore.entity.device.Brand;
import com.example.onlinestore.entity.device.Device;
import com.example.onlinestore.entity.device.DeviceType;
import com.example.onlinestore.exceptions.notFoundException.BrandNotFoundException;
import com.example.onlinestore.exceptions.notFoundException.DeviceNotFoundException;
import com.example.onlinestore.exceptions.notFoundException.DeviceTypeNotFoundException;
import com.example.onlinestore.repos.device.BrandRepo;
import com.example.onlinestore.service.device.BrandService;
import com.example.onlinestore.service.device.DeviceService;
import com.example.onlinestore.service.device.DeviceTypeService;
import com.example.onlinestore.service.user.UserService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/admin/device")
@Api(value = "Admin controller")
public class AdminDeviceControllerV1 {

    private final UserService userService;
    private final DeviceService deviceService;
    private final DeviceTypeService deviceTypeService;
    private final BrandService brandService;

    public AdminDeviceControllerV1(UserService userService,
                                   DeviceService deviceService,
                                   DeviceTypeService deviceTypeService,
                                   BrandService brandService) {
        this.userService = userService;
        this.deviceService = deviceService;
        this.deviceTypeService = deviceTypeService;
        this.brandService = brandService;
    }



    @GetMapping("/type")
    public ResponseEntity<List<DeviceType>> getTypes() throws DeviceTypeNotFoundException {
        return new ResponseEntity<>(deviceTypeService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/type")
    public ResponseEntity<DeviceType> saveType(@RequestBody DeviceType deviceType) {
        return new ResponseEntity<>(deviceTypeService.save(deviceType), HttpStatus.OK);
    }



    @GetMapping("/brand")
    public ResponseEntity<List<Brand>> getBrands() throws BrandNotFoundException {
        return new ResponseEntity<>(brandService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/brand/{id}")
    public ResponseEntity<List<Brand>> getBrandsByTypeId(@PathVariable Long id) throws BrandNotFoundException {
        return new ResponseEntity<>(brandService.getAllByDeviceTypeId(id), HttpStatus.OK);
    }
    @PostMapping("/brand")
    public ResponseEntity<Brand> saveBrand(@RequestBody Brand brand) {
        return new ResponseEntity<>(brandService.save(brand), HttpStatus.OK);
    }



    @GetMapping
    public ResponseEntity<List<Device>> getDevices() throws DeviceNotFoundException {
        return new ResponseEntity<>(deviceService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Device>> getDevicesByBrandId(@PathVariable Long id) throws DeviceNotFoundException {
        return new ResponseEntity<>(deviceService.getAllByBrandId(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Device> saveDevice(@RequestBody NewDeviceDto newDeviceDto)  {
        return new ResponseEntity<>(deviceService.save(NewDeviceDto.ToDevice(newDeviceDto)), HttpStatus.OK);
    }

}
