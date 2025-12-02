create type qualification as enum ('CAT_WATCHER', 'DOG_WATCHER', 'VETERINARIAN', 'CLEANER');

create table employees
(
    id            int primary key not null,
    name          varchar(30)     not null,
    surname       varchar(30)     not null,
    phone_number  varchar(13)     not null check (phone_number ~ '^\+\d{12}$'),
    address       varchar(30)     not null,
    qualification qualification   not null,
    foreign key (id) references users (id) on update cascade on delete restrict
);