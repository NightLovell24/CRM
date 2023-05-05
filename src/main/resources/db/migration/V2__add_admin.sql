INSERT INTO user_credentials(id, mail, name, is_enabled, role, password)
VALUES (1, 'admin@mail.ru', 'Admin', true, 'ADMIN', '1488');

INSERT INTO admin(id, user_credentials_id)
VALUES (1, 1);