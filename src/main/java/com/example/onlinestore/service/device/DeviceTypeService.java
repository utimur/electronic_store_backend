package com.example.onlinestore.service.device;

import com.example.onlinestore.entity.device.DeviceType;
import com.example.onlinestore.exceptions.existException.DeviceTypeAlreadyExist;
import com.example.onlinestore.exceptions.notFoundException.DeviceTypeNotFoundException;
import com.example.onlinestore.repos.device.DeviceTypeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceTypeService {
    private final DeviceTypeRepo deviceTypeRepo;

    public DeviceTypeService(DeviceTypeRepo deviceTypeRepo) {
        this.deviceTypeRepo = deviceTypeRepo;
    }

    public DeviceType getById(Long id) throws DeviceTypeNotFoundException {
        if(deviceTypeRepo.findById(id) == null){
            throw new DeviceTypeNotFoundException("Device type with id " + id + " not found");
        }
        return deviceTypeRepo.findById(id).get();
    }



    public List<DeviceType> getAll() throws DeviceTypeNotFoundException {
        List<DeviceType> devices = deviceTypeRepo.findAll();
        if(devices.size() == 0){
            throw new DeviceTypeNotFoundException("Device types not found");
        }
        return devices;
    }

    public void save(DeviceType deviceType) throws DeviceTypeAlreadyExist {
        if(deviceTypeRepo.findByName(deviceType.getName()) != null){
            throw new DeviceTypeAlreadyExist("Device types not found");
        } else{
            deviceTypeRepo.save(deviceType);
        }
    }
}
