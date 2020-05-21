package com.example.onlinestore.repos.device;

import com.example.onlinestore.entity.device.DeviceType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeviceTypeRepo extends CrudRepository<DeviceType, Long> {
    List<DeviceType> findAll();

    DeviceType findByName(String name);
}
