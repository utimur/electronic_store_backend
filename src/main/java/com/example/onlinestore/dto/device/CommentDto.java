package com.example.onlinestore.dto.device;

import com.example.onlinestore.dto.user.UserDto;
import com.example.onlinestore.entity.device.Comment;
import com.example.onlinestore.entity.device.Like;
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

    private Boolean isLiked;

    public static CommentDto fromComment(Comment comment, Long userId) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setUser(UserDto.fromUser(comment.getUser()));
        commentDto.setLikeCount(comment.getLikeCount());
        commentDto.setDislikeCount(comment.getDislikeCount());
        commentDto.setCreated(comment.getCreated());
        commentDto.setText(comment.getText());
        commentDto.setRating(comment.getRating());
        commentDto.setDeviceId(comment.getDevice().getId());
        if (comment.getLikes() != null) {
            for (Like like: comment.getLikes()) {
                if (like.getUser().getId().equals(userId)) {
                    commentDto.setIsLiked(true);
                }
            }
        }
        return commentDto;
    }


}
