package com.example.onlinestore.entity.device;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    private String name;

    private String description;
}
