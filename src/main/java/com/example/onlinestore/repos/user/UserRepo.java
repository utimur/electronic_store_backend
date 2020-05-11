package com.example.onlinestore.repos.user;

import com.example.onlinestore.entity.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Long> {

}
