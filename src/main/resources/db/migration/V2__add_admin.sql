INSERT INTO user_credentials(id, mail, name, is_enabled, role, password)
VALUES (1, 'admin@mail.ru', 'Admin', true, 'ADMIN', '$2a$12$3rrGlAM2g50Qa73EtNb1B.socdywmauH6CHeOH6HjWw/rVYILytni');

INSERT INTO admin(id, user_credentials_id)
VALUES (1, 1);