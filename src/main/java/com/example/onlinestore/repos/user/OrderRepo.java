package com.example.onlinestore.repos.user;

import com.example.onlinestore.entity.user.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, Long> {
}
