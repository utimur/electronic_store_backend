package com.example.onlinestore.entity.device;

import com.example.onlinestore.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Model extends BaseEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToOne(mappedBy = "model")
    private Device device;
}
