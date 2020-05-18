package com.example.onlinestore.repos.user;

import com.example.onlinestore.entity.user.Basket;
import org.springframework.data.repository.CrudRepository;

public interface BasketRepo extends CrudRepository<Basket, Long> {
}
