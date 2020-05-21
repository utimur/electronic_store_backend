create table hibernate_sequence (
    next_val bigint
) engine=MyISAM;

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

CREATE TABLE usr (
    id BIGINT NOT NULL AUTO_INCREMENT,
    password VARCHAR(64) NOT NULL,
    username VARCHAR(64) NOT NULL,
    mail VARCHAR(64) NOT NULL,
    phone_number VARCHAR(11),
    avatar VARCHAR(64),
    PRIMARY KEY (id)
) engine=myISAM;

CREATE TABLE roles (
    id BIGINT NOT NULL AUTO_INCREMENT,
    role VARCHAR(32) NOT NULL,
    PRIMARY KEY (id)
) engine=myISAM;

CREATE TABLE basket (
    id BIGINT NOT NULL AUTO_INCREMENT,
    device_id BIGINT NOT NULL references device,
    user_id BIGINT NOT NULL references usr,
    PRIMARY KEY (id)
) engine=myISAM;

CREATE TABLE favourite (
    id BIGINT NOT NULL AUTO_INCREMENT,
    device_id BIGINT NOT NULL references device,
    user_id BIGINT NOT NULL references usr,
    PRIMARY KEY (id)
) engine=myISAM;

CREATE TABLE orders (
    id BIGINT NOT NULL AUTO_INCREMENT,
    device_id BIGINT NOT NULL references device,
    user_id BIGINT NOT NULL references usr,
    address VARCHAR(255) NOT NULL,
    delivery_date VARCHAR(64) NOT NULL,
    comment VARCHAR(255),
    PRIMARY KEY (id)
) engine=myISAM;




CREATE TABLE device (
    id BIGINT NOT NULL AUTO_INCREMENT,
    count BIGINT DEFAULT 0,
    model_id BIGINT NOT NULL REFERENCES model,
    price BIGINT NOT NULL ,
    rating FLOAT DEFAULT 0,
    PRIMARY KEY (id)
) engine=myISAM;

CREATE TABLE brand(
    id BIGINT NOT NULL AUTO_INCREMENT,
    device_type_id BIGINT NOT NULL REFERENCES device_type,
    name VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
) engine=myISAM;

CREATE TABLE device_type(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
) engine=myISAM;

CREATE TABLE model (
    id BIGINT NOT NULL AUTO_INCREMENT,
    brand_id BIGINT NOT NULL references brand,
    name VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
) engine=myISAM;

CREATE TABLE comment (
    id BIGINT NOT NULL AUTO_INCREMENT,
    device_id BIGINT NOT NULL references device,
    user_id BIGINT NOT NULL references usr,
    text varchar(512) NOT NULL,
    like_count BIGINT DEFAULT 0,
    dislike_count BIGINT DEFAULT 0,
    PRIMARY KEY (id)
) engine=myISAM;

CREATE TABLE property (
    id BIGINT NOT NULL AUTO_INCREMENT,
    device_id BIGINT NOT NULL references device,
    name VARCHAR (32) NOT NULL,
    description VARCHAR(512) NOT NULL,
    PRIMARY KEY (id)
) engine=myISAM;


CREATE TABLE user_roles (
    user_id BIGINT NOT NULL references usr,
    role_id BIGINT NOT NULL references role,
    PRIMARY KEY (user_id, role_id)
) engine=myISAM;



