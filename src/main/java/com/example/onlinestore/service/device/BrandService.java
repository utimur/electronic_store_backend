package com.example.onlinestore.service.device;

import com.example.onlinestore.entity.device.Brand;
import com.example.onlinestore.exceptions.existException.BrandAlreadyExist;
import com.example.onlinestore.exceptions.notFoundException.BrandNotFoundException;
import com.example.onlinestore.repos.device.BrandRepo;
import com.example.onlinestore.repos.device.DeviceTypeRepo;
import org.springframework.stereotype.Service;

import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
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

    public void save(Brand brand) {
        if(brandRepo.findByName(brand.getName()) != null) {
            throw new BrandAlreadyExist("Brand with name " + brand.getName() + " already exist");
        }
        brandRepo.save(brand);
    }
}
