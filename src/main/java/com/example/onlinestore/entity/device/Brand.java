package com.example.onlinestore.entity.device;

import com.example.onlinestore.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Brand extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Model> models;

    @ManyToOne
    @JoinColumn(name = "device_type_id")
    private DeviceType deviceType;
}
