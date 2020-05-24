package com.example.onlinestore.entity.device;

import com.example.onlinestore.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "device_id")
    @JsonIgnore
    private Device device;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String text;

    private Long likeCount;

    private Long dislikeCount;
}
