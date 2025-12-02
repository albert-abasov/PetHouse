create type pet_type as enum ('CAT', 'DOG');

create table rooms
(
    id    SERIAL primary key not null,
    type  pet_type           not null,
    price int                not null check (price between 200 and 300)
);