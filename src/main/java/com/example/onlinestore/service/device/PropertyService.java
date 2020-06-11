package com.example.onlinestore.service.device;

import com.example.onlinestore.entity.device.Property;
import com.example.onlinestore.exceptions.existException.PropertyAlreadyExist;
import com.example.onlinestore.repos.device.PropertyRepo;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {
    private final PropertyRepo propertyRepo;

    public PropertyService(PropertyRepo propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    public Property save(Property property) {
        if (propertyRepo.findByName(property.getName()) != null) {
            throw new PropertyAlreadyExist("Property with name " + property.getName() + " already exist");
        }
        return propertyRepo.save(property);
    }
}
