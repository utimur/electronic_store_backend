INSERT INTO usr_role values (1, "user");
INSERT INTO usr_role values (2, "admin");

INSERT INTO usr(id, password, username, mail, phone_number,role_id)
        values(1,"admin", "admin", "admin@mail.ru", "89670000101", 2);

INSERT INTO device_type values (1, "Смартфоны");
INSERT INTO device_type values (2, "Ноутбуки");

INSERT INTO brand values (1,1, "Apple");
INSERT INTO brand values (2,1, "Samsung");

INSERT INTO model values (1,1, "11 pro");
INSERT INTO model values (2,1, "SE");


