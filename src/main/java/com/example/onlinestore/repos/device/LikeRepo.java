package com.example.onlinestore.repos.device;

import com.example.onlinestore.entity.device.Like;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepo extends CrudRepository<Like, Long> {
    Like findByCommentId(Long commentId);

    Like findByUserId(Long userId);
}
