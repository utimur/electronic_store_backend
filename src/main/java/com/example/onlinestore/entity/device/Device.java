package com.example.onlinestore.entity.device;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

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
