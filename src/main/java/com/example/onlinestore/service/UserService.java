package com.example.onlinestore.service;

import com.example.onlinestore.entity.user.User;

import java.util.List;

public interface UserService {
    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);
}
