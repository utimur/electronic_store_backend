package com.example.onlinestore.entity.device;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

}
