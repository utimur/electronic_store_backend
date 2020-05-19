INSERT INTO role values (1, "user");
INSERT INTO role values (2, "admin");

INSERT INTO usr(id, password, username, mail, phone_number)
        values(1,"$2a$04$dpjjv5YugO251hzoMV4nQOMR3dOo/VBMdBkn9xI9nvky61Pdow27u", "admin", "admin@mail.ru", "89670000101");

INSERT INTO device_type values (1, "Смартфоны");
INSERT INTO device_type values (2, "Ноутбуки");

INSERT INTO brand values (1,1, "Apple");
INSERT INTO brand values (2,1, "Samsung");

INSERT INTO model values (1,1, "11 pro");
INSERT INTO model values (2,1, "SE");

INSERT INTO user_roles values (1,1);
INSERT INTO user_roles values (1,2);


