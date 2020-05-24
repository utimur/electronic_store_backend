package com.example.onlinestore.entity.user;

import com.example.onlinestore.entity.device.Device;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

}
