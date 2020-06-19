package com.example.onlinestore.service.user;


import com.example.onlinestore.entity.user.User;

import java.util.List;

public interface UserService {

    User register(User user);

    User getByUsername(String username);

    User getByMail(String mail);

    User getById(Long id);

    List<User> getAll();

    void delete(Long id);

    void update(User user);


}
