package com.example.onlinestore.entity.user;


import com.example.onlinestore.entity.BaseEntity;
import com.example.onlinestore.entity.device.Device;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders")
public class Order extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    private String address;

    private String deliveryDate;

    private String comment;


}
