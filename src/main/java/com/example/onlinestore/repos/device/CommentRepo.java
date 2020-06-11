package com.example.onlinestore.repos.device;

import com.example.onlinestore.entity.device.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepo extends CrudRepository<Comment, Long> {

    List<Comment> findCommentsByDeviceId(Long deviceId);
}
