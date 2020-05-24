INSERT INTO roles values (1, "ROLE_USER");
INSERT INTO roles values (2, "ROLE_ADMIN");

INSERT INTO usr(password, username, mail, phone_number)
        values("$2a$04$zUk5psHVasW8ZTh6yLE/T.tIkJM1M5aNgeXb0E6inUihrTGl0CY5e", "admin", "admin@mail.ru", "89670000101");

INSERT INTO usr(password, username, mail, phone_number)
        values("$2a$04$zUk5psHVasW8ZTh6yLE/T.tIkJM1M5aNgeXb0E6inUihrTGl0CY5e", "usr", "user@mail.ru", "89670000107");

INSERT INTO usr(password, username, mail, phone_number)
        values("$2a$04$zUk5psHVasW8ZTh6yLE/T.tIkJM1M5aNgeXb0E6inUihrTGl0CY5e", "test", "test@mail.ru", "89670000107");


INSERT INTO device_type values (1, "Смартфоны");
INSERT INTO device_type values (2, "Ноутбуки");

INSERT INTO brand values (1,1, "Apple");
INSERT INTO brand values (2,1, "Samsung");

INSERT INTO device values (1,1,"11 pro", 1, "", 120000, 0);
INSERT INTO device values (2,3, "SE",1, "", 52000, 0);
INSERT INTO device values (3,3, "10",2, "", 65000, 0);

INSERT INTO user_roles values (1,1);
INSERT INTO user_roles values (1,2);

INSERT INTO user_roles values (2,1);
INSERT INTO user_roles values (3,1);
INSERT INTO user_roles values (3,2);




