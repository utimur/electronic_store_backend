package com.example.onlinestore.entity.user;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usr_role")
@Getter
@Setter
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String role;

    @OneToOne(mappedBy = "role")
    User user;
}
