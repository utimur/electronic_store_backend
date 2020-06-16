package com.example.onlinestore.repos.device;

import com.example.onlinestore.entity.device.Dislike;
import org.springframework.data.repository.CrudRepository;

public interface DislikeRepo extends CrudRepository<Dislike, Long> {
    Dislike findByCommentId(Long commentId);

    Dislike findByUserId(Long userId);

}
