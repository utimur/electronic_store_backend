package com.example.onlinestore.repos.device;

import com.example.onlinestore.entity.device.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrandRepo extends CrudRepository<Brand, Long> {
    List<Brand> findBrandsByDeviceTypeId(Long deviceTypeId);

    Brand findByName(String name);
    Brand findByNameAndDeviceTypeId(String name, Long deviceTypeId );
    Brand findByNameAndDeviceTypeName(String name, String deviceTypeName );

    List<Brand> findAll();

    void deleteByNameAndDeviceTypeName(String name, String deviceTypeName);
}
