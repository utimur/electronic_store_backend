package com.example.onlinestore.repos.device;

import com.example.onlinestore.entity.device.Property;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepo extends CrudRepository<Property, Long> {
}
