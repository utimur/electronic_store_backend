package com.example.onlinestore.service.device;

import com.example.onlinestore.entity.device.Comment;
import com.example.onlinestore.repos.device.CommentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepo commentRepo;

    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    public Comment save(Comment comment) {
        return commentRepo.save(comment);
    }

    public List<Comment> getByDeviceId(Long deviceId) {
        return commentRepo.findCommentsByDeviceId(deviceId);
    }

    public Comment getById(Long id) {
        return commentRepo.findById(id).get();
    }
}
