package com.example.onlinestore.entity.device;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Brand  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Device> models;

    @ManyToOne
    @JoinColumn(name = "device_type_id")
    @JsonIgnore
    private DeviceType deviceType;
}
