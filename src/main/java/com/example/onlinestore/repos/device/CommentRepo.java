package com.example.onlinestore.repos.device;

import com.example.onlinestore.entity.device.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<Comment, Long> {
}
