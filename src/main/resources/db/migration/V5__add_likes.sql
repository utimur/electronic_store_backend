CREATE TABLE likes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    comment_id BIGINT NOT NULL references comment,
    user_id BIGINT NOT NULL references usr,
    PRIMARY KEY (id)
) engine=myISAM;

CREATE TABLE dislikes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    comment_id BIGINT NOT NULL references comment,
    user_id BIGINT NOT NULL references usr,
    PRIMARY KEY (id)
) engine=myISAM;
