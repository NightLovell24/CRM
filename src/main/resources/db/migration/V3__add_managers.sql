INSERT INTO user_credentials(id, mail, name, is_enabled, role, password)
VALUES (2, 'josh@mail.ua', 'Josh', true, 'MANAGER', '$2a$12$3rrGlAM2g50Qa73EtNb1B.socdywmauH6CHeOH6HjWw/rVYILytni'),
       (3, 'muzey@gmail.com', 'Ivan', true, 'MANAGER', '$2a$12$3rrGlAM2g50Qa73EtNb1B.socdywmauH6CHeOH6HjWw/rVYILytni');

INSERT INTO manager(id, user_credentials_id)
VALUES (1, 2),
       (2, 3);
