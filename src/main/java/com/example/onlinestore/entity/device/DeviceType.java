package com.example.onlinestore.entity.device;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "device_type")
@Getter
@Setter
public class DeviceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "deviceType", cascade = CascadeType.ALL)
    private List<Brand> brands;
    @OneToMany(mappedBy = "deviceType", cascade = CascadeType.ALL)
    private List<Brand> devices;

}
