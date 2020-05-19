package com.example.onlinestore.entity.device;

import com.example.onlinestore.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "device_type")
@Getter
@Setter
public class DeviceType extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "deviceType")
    private List<Brand> brands;

}
