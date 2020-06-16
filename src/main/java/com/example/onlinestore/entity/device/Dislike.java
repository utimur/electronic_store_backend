package com.example.onlinestore.entity.device;

import com.example.onlinestore.entity.user.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "dislikes")
public class Dislike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;
}
