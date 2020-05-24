package com.example.onlinestore.repos.device;

import com.example.onlinestore.entity.device.Device;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeviceRepo extends CrudRepository<Device, Long> {
    List<Device> findAll();

    List<Device> findDevicesByBrandId(Long brandId);

    Device findByName(String name);
}
