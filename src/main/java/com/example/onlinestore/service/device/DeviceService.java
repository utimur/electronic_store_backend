package com.example.onlinestore.service.device;


import com.example.onlinestore.entity.device.Device;
import com.example.onlinestore.entity.device.Model;
import com.example.onlinestore.exceptions.notFoundException.DeviceNotFoundException;
import com.example.onlinestore.repos.device.DeviceRepo;
import com.example.onlinestore.repos.device.ModelRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    private final DeviceRepo deviceRepo;
    private final ModelRepo modelRepo;

    public DeviceService(DeviceRepo deviceRepo, ModelRepo modelRepo) {
        this.deviceRepo = deviceRepo;
        this.modelRepo = modelRepo;
    }

    public Device getById(Long id) throws DeviceNotFoundException {
        if(deviceRepo.findById(id) == null){
            throw new DeviceNotFoundException("Device with id " + id + " not found");
        }
        return deviceRepo.findById(id).get();
    }

    public Device getByModelName(String modelName) throws DeviceNotFoundException {
        Model model = modelRepo.findByName(modelName);
        if (model == null) {
            throw new DeviceNotFoundException("Device with model name " + modelName + " not found");
        }
        Device device = deviceRepo.findByModelId(model.getId());
        if(device == null){
            throw new DeviceNotFoundException("Device with model name " + modelName + " not found");
        }
        return device;
    }

    public List<Device> getAll() throws DeviceNotFoundException {
        List<Device> devices = deviceRepo.findAll();
        if(devices.size() == 0){
            throw new DeviceNotFoundException("Devices not found");
        }
        return devices;
    }

    public void save(Device device) {
        deviceRepo.save(device);
    }
}
