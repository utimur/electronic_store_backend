package com.example.onlinestore.entity.device;


import com.example.onlinestore.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Property  extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    private String name;

    private String description;
}
