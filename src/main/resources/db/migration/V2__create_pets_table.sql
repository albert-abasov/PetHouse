create type pet_type as enum ('CAT', 'DOG');

create table pets
(
    id           SERIAL primary key not null,
    name         varchar(30)        not null,
    type         pet_type           not null,
    breed        varchar(30),
    pet_owner_id int                not null,
    description  varchar(300)       not null,
    special_diet boolean            not null,
    foreign key (pet_owner_id) references pet_owners (id) on update cascade on delete restrict
);