package com.example.onlinestore.entity.user;

import com.example.onlinestore.entity.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "usr")
@Data
@NoArgsConstructor
public class User extends BaseEntity {


    private String password;

    @Size(min = 3, max = 15, message = "Uncorrect username")
    private String username;

    @Email(message = "Uncorrect email")
    private String mail;

    private String phoneNumber;

    private String avatar;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
    @OneToMany(mappedBy = "user")
    private List<Basket> baskets;
    @OneToMany(mappedBy = "user")
    private List<Favourite> favourites;
}
