--ADMINS
create table admin
(
    id                  bigserial not null,
    user_credentials_id bigint,
    primary key (id)
);
--CLIENTS
create table client
(
    id           bigserial not null,
    created      timestamp(6),
    name         varchar(255),
    phone_number varchar(255),
    status       varchar(255),
    manager_id   bigint,
    primary key (id)
);
--COMMENTS
create table client_comment
(
    id        bigserial not null,
    created   timestamp(6),
    info      varchar(255),
    client_id bigint,
    primary key (id)
);
--DEPOSITS
create table deposit
(
    id            bigserial not null,
    rounding_mode smallint,
    scale         integer   not null,
    sum           numeric(38, 2),
    manager_id    bigint,
    primary key (id)
);
--MANAGERS
create table managers
(
    id                  bigserial not null,
    user_credentials_id bigint,
    manager_id          bigint,
    primary key (id)
);
--USER_CREDENTIALS
create table user_credentials
(
    id        bigserial not null,
    mail      varchar(255),
    name      varchar(255),
    is_enabled boolean DEFAULT true,
    role      varchar(255),
    password  varchar(255),
    primary key (id)
);
alter table if exists admin
    add constraint admin_fk_user_credentials foreign key (user_credentials_id) references user_credentials;
alter table if exists client
    add constraint client_fk_managers foreign key (manager_id) references managers;
alter table if exists client_comment
    add constraint client_comment_fk_client foreign key (client_id) references client;
alter table if exists deposit
    add constraint deposit_fk_managers foreign key (manager_id) references managers;
alter table if exists managers
    add constraint managers_fk_user_credentials foreign key (user_credentials_id) references user_credentials;
alter table if exists managers
    add constraint managers_fk_admin foreign key (manager_id) references admin;
