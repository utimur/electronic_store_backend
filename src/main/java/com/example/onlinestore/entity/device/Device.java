package com.example.onlinestore.entity.device;


import com.example.onlinestore.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Device extends BaseEntity {

    private Long count;

    @OneToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private Model model;

    private Long price;

    private Float rating;

    @OneToMany(mappedBy = "device")
    private List<Property> properties;

    @OneToMany(mappedBy = "device")
    private List<Comment> comments;

}
