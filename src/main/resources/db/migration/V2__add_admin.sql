INSERT INTO user_credentials(id, mail, password)
VALUES (1, 'admin@mail.ru', '1488');

INSERT INTO admin(id, name, user_credentials_id)
VALUES (1, 'Admin', 1);