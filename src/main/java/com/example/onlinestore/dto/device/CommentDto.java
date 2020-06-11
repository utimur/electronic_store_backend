package com.example.onlinestore.dto.device;

import com.example.onlinestore.dto.user.UserDto;
import com.example.onlinestore.entity.device.Comment;
import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private Long deviceId;
    private UserDto user;

    private String text;

    private Long likeCount;
    private Long dislikeCount;

    private String created;
    private Long rating;


    public static CommentDto fromComment(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setUser(UserDto.fromUser(comment.getUser()));
        commentDto.setLikeCount(comment.getLikeCount());
        commentDto.setDislikeCount(comment.getDislikeCount());
        commentDto.setCreated(comment.getCreated());
        commentDto.setText(comment.getText());
        commentDto.setRating(comment.getRating());
        commentDto.setDeviceId(comment.getDevice().getId());
        return commentDto;
    }

}
