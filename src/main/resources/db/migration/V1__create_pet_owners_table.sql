create table pet_owners
(
    id           int primary key not null,
    name         varchar(30)     not null,
    surname      varchar(30)     not null,
    phone_number varchar(13)     not null check (phone_number ~ '^\+\d{12}$'),
    address      varchar(30)     not null
);