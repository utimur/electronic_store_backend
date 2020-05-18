package com.example.onlinestore.repos.user;

import com.example.onlinestore.entity.user.Favourite;
import org.springframework.data.repository.CrudRepository;

public interface FavouriteRepo extends CrudRepository<Favourite, Long> {
}
