package com.example.onlinestore.service.device;

import com.example.onlinestore.entity.device.Brand;
import com.example.onlinestore.exceptions.existException.BrandAlreadyExist;
import com.example.onlinestore.exceptions.notFoundException.BrandNotFoundException;
import com.example.onlinestore.repos.device.BrandRepo;
import com.example.onlinestore.repos.device.DeviceTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BrandService {


    private final BrandRepo brandRepo;

    public BrandService(BrandRepo brandRepo) {
        this.brandRepo = brandRepo;
    }

    public List<Brand> getAllByDeviceTypeId(Long id) throws BrandNotFoundException {
        List<Brand> brands = brandRepo.findBrandsByDeviceTypeId(id);
        if(brands.size()==0){
            throw new BrandNotFoundException("Brands with device type id " + id + " not fount");
        }
        return brands;
    }

    public Brand save(Brand brand) {
        if(brandRepo.findByNameAndDeviceTypeId(brand.getName(), brand.getDeviceType().getId()) != null) {
            throw new BrandAlreadyExist("Brand with name " + brand.getName() + " already exist");
        }
        return brandRepo.save(brand);
    }

    public List<Brand> getAll() throws BrandNotFoundException {
        List<Brand> brands = brandRepo.findAll();
        if (brands.size() == 0) {
            throw new BrandNotFoundException("Brands not found");
        }
        return brands;
    }

    public Brand getByName(String name) throws BrandNotFoundException {
        Brand brand = brandRepo.findByName(name);
        if (brand == null) {
            throw new BrandNotFoundException("Brands not found");
        }
        return brand;
    }
    public Brand getByNameAndTypeName(String name, String typeName) throws BrandNotFoundException {
        Brand brand = brandRepo.findByNameAndDeviceTypeName(name, typeName);
        if (brand == null) {
            throw new BrandNotFoundException("Brands not found");
        }
        return brand;
    }

    @Transactional
    public void deleteByNameAndTypeName(String name, String typeName) throws BrandNotFoundException {
        if (brandRepo.findByNameAndDeviceTypeName(name, typeName) == null) {
            throw new BrandNotFoundException("Brand not found");
        }
        brandRepo.deleteByNameAndDeviceTypeName(name, typeName);
    }
}
