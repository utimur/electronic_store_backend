package com.example.onlinestore.entity.user;


import com.example.onlinestore.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
public class Role extends BaseEntity {

    private String role;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;
}
