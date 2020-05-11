package com.example.onlinestore.repos.device;

import com.example.onlinestore.entity.device.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepo extends CrudRepository<Device, Long> {
}
