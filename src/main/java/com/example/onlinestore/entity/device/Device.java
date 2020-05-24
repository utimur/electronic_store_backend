package com.example.onlinestore.entity.device;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Device  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long count;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @JsonIgnore
    private Brand brand;

    private String name;

    private Long price;

    private Float rating;

    private String image;

    @OneToMany(mappedBy = "device")
    private List<Property> properties;

    @OneToMany(mappedBy = "device")
    private List<Comment> comments;

}
