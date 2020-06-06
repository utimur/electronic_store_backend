package com.example.onlinestore.service.device;

import com.example.onlinestore.entity.device.DeviceType;
import com.example.onlinestore.exceptions.existException.DeviceTypeAlreadyExist;
import com.example.onlinestore.exceptions.notFoundException.DeviceTypeNotFoundException;
import com.example.onlinestore.repos.device.DeviceTypeRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeviceTypeService {
    private final DeviceTypeRepo deviceTypeRepo;

    public DeviceTypeService(DeviceTypeRepo deviceTypeRepo) {
        this.deviceTypeRepo = deviceTypeRepo;
    }

    public DeviceType getById(Long id) throws DeviceTypeNotFoundException {
        if(deviceTypeRepo.findById(id).get() == null){
            throw new DeviceTypeNotFoundException("Device type with id " + id + " not found");
        }
        return deviceTypeRepo.findById(id).get();
    }

    public DeviceType getByName(String name) throws DeviceTypeNotFoundException {
        if(deviceTypeRepo.findByName(name) == null){
            throw new DeviceTypeNotFoundException("Device type with name " + name + " not found");
        }
        return deviceTypeRepo.findByName(name);
    }

    public List<DeviceType> getAll() throws DeviceTypeNotFoundException {
        List<DeviceType> devices = deviceTypeRepo.findAll();
        if(devices.size() == 0){
            throw new DeviceTypeNotFoundException("Device types not found");
        }
        return devices;
    }

    public DeviceType save(DeviceType deviceType) throws DeviceTypeAlreadyExist {
        if(deviceTypeRepo.findByName(deviceType.getName()) != null){
            throw new DeviceTypeAlreadyExist("Device types not found");
        } else{
           return deviceTypeRepo.save(deviceType);
        }
    }

    @Transactional
    public void deleteByName(String name) throws DeviceTypeNotFoundException {
        if(deviceTypeRepo.findByName(name) == null){
            throw new DeviceTypeNotFoundException("Device types not found");
        } else{
            deviceTypeRepo.deleteByName(name);
        }
    }
}
