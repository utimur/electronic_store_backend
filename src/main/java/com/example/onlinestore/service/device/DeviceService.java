package com.example.onlinestore.service.device;


import com.example.onlinestore.entity.device.Device;
import com.example.onlinestore.exceptions.existException.DeviceAlreadyExist;
import com.example.onlinestore.exceptions.existException.DeviceTypeAlreadyExist;
import com.example.onlinestore.exceptions.notFoundException.DeviceNotFoundException;
import com.example.onlinestore.repos.device.DeviceRepo;
import com.example.onlinestore.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class DeviceService {

    private final DeviceRepo deviceRepo;

    public DeviceService(DeviceRepo deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    public Device getById(Long id) throws DeviceNotFoundException {
        if(deviceRepo.findById(id) == null){
            throw new DeviceNotFoundException("Device with id " + id + " not found");
        }
        return deviceRepo.findById(id).get();
    }

    public List<Device> getAllByBrandId(Long brandId) throws DeviceNotFoundException {
        List<Device> devices = deviceRepo.findDevicesByBrandId(brandId);
        if (devices.size() == 0) {
            throw new DeviceNotFoundException("Devices with brand id " + brandId + " not found");
        }
        return devices;
    }

    public List<Device> getAllByTypeId(Long deviceTypeId) throws DeviceNotFoundException {
        List<Device> devices = deviceRepo.findDevicesByDeviceTypeId(deviceTypeId);
        if (devices.size() == 0) {
            throw new DeviceNotFoundException("Devices with type id " + deviceTypeId + " not found");
        }
        return devices;
    }

    public List<Device> getAllByTypeIdAndBrandId(Long deviceTypeId, Long brandId) throws DeviceNotFoundException {
        List<Device> devices = deviceRepo.findDevicesByDeviceTypeIdAndBrandId(deviceTypeId,brandId);
        if (devices.size() == 0) {
            throw new DeviceNotFoundException("Devices with type id " + deviceTypeId + " not found");
        }
        return devices;
    }

    public List<Device> getAll() throws DeviceNotFoundException {
        List<Device> devices = deviceRepo.findAll();
        if(devices.size() == 0){
            throw new DeviceNotFoundException("Devices not found");
        }
        return devices;
    }

    public Device save(Device device) {
        if (deviceRepo.findByName(device.getName()) != null) {
            throw new DeviceAlreadyExist("Device with name " + device.getName() + " already exist");
        }
        return deviceRepo.save(device);
    }



    public void update(Device device) {
        deviceRepo.save(device);
    }
}
