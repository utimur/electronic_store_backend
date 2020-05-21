package com.example.onlinestore.service.user;


import com.example.onlinestore.entity.user.User;

import java.util.List;

public interface UserService {

    User register(User user);

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);


}
