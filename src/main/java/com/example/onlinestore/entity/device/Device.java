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

    private Long count = new Long(0);

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @JsonIgnore
    private Brand brand;

    private String name;

    private Long price;

    private Float rating = new Float(0);

    private String image;

    @OneToMany(mappedBy = "device",  cascade = CascadeType.ALL)
    private List<Property> properties;

    @OneToMany(mappedBy = "device",  cascade = CascadeType.ALL)
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name ="type_id")
    private DeviceType deviceType;

}
