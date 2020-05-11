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
    role_id BIGINT DEFAULT 1 REFERENCES usr_role,
    PRIMARY KEY (id)
) engine=myISAM;

CREATE TABLE usr_role (
    id BIGINT NOT NULL AUTO_INCREMENT,
    role VARCHAR(32) NOT NULL,
    PRIMARY KEY (id)
) engine=myISAM;



CREATE TABLE device (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
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

