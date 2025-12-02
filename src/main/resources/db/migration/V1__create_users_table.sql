create type user_role as enum ('ADMIN', 'MANAGER', 'EMPLOYEE', 'PET_OWNER');

create table users
(
    id       serial primary key not null,
    login    varchar(50)        not null,
    password varchar(255)       not null,
    email    varchar(50)        not null check (email ~ '^.+@[a-z]+\.[a-z]+$'),
    role     user_role          not null default ('PET_OWNER')
);