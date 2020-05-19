package com.example.onlinestore.entity.device;

import com.example.onlinestore.entity.BaseEntity;
import com.example.onlinestore.entity.user.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String text;

    private Long likeCount;

    private Long dislikeCount;
}
