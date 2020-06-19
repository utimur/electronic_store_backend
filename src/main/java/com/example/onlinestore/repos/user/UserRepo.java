package com.example.onlinestore.repos.user;

import com.example.onlinestore.entity.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User,Long> {
    User findByUsername(String username);

    List<User> findAll();

    User findByMail(String mail);
}
