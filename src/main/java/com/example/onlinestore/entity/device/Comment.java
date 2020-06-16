package com.example.onlinestore.entity.device;

import com.example.onlinestore.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Comment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String text;

    private Long likeCount = new Long(0);

    private Long dislikeCount = new Long(0);
    private String created = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
    private Long rating = new Long(0);

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<Like> likes;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<Dislike> dislikes;
}
