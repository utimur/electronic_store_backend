package com.example.onlinestore.controller.v1;


import com.example.onlinestore.dto.device.CommentDto;
import com.example.onlinestore.entity.device.Comment;
import com.example.onlinestore.entity.device.Device;
import com.example.onlinestore.entity.device.Like;
import com.example.onlinestore.entity.user.User;
import com.example.onlinestore.exceptions.notFoundException.DeviceNotFoundException;
import com.example.onlinestore.repos.device.LikeRepo;
import com.example.onlinestore.service.device.CommentService;
import com.example.onlinestore.service.device.DeviceService;
import com.example.onlinestore.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/comments")
@CrossOrigin
public class CommentController {

    private final CommentService commentService;
    private final DeviceService deviceService;
    private final UserService userService;
    private final LikeRepo likeRepo;

    public CommentController(CommentService commentService, DeviceService deviceService, UserService userService, LikeRepo likeRepo) {
        this.commentService = commentService;
        this.deviceService = deviceService;
        this.userService = userService;
        this.likeRepo = likeRepo;
    }


    @PostMapping("/add")
    public ResponseEntity addComment(@RequestBody Comment comment) throws DeviceNotFoundException {
        Float rateSum = new Float(0);
        User user = userService.getById(comment.getUser().getId());
        Device device = deviceService.getById(comment.getDevice().getId());
        comment.setUser(user);
        comment.setDevice(device);

        for (Comment com: device.getComments()) {
            rateSum+= com.getRating();
        }
        rateSum+=comment.getRating();

        device.setRating(rateSum / (device.getComments().size()+1));
        deviceService.update(device);

        Map<Object, Object> response = new HashMap<>();
        response.put("rating", device.getRating());
        response.put("comment", CommentDto.fromComment(commentService.save(comment),user.getId()));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity getByDeviceId(@RequestParam("device_id") Long deviceId,
                                        @RequestParam("user_id") Long userId) {
        return ResponseEntity.ok(commentService.getByDeviceId(deviceId).stream()
        .map(comment -> CommentDto.fromComment(comment, userId)).collect(Collectors.toList()));
    }

    @PostMapping("/like")
    public ResponseEntity like(@RequestBody Like like) {
        User user = userService.getById(like.getUser().getId());
        Comment comment = commentService.getById(like.getComment().getId());
        like.setUser(user);
        like.setComment(comment);
        if (likeRepo.findByUserId(user.getId()) == null) {
            comment.getLikes().add(like);
            comment.setLikeCount(comment.getLikeCount()+1);
        } else {
            comment.setLikeCount(comment.getLikeCount()-1);
            likeRepo.deleteById(likeRepo.findByUserId(user.getId()).getId());
        }


        return ResponseEntity.ok(CommentDto.fromComment(commentService.save(comment), like.getUser().getId()));
    }
}
