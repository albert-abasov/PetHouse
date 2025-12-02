create table accommodation
(
    id            serial primary key not null,
    pet_id        int                not null,
    check_in_date date               not null check (check_in_date >= CURRENT_DATE),
    eviction_date date check (eviction_date >= check_in_date),
    cared_by_id   int                not null,
    room_id       int                not null,
    foreign key (pet_id) references pets (id) on update cascade on delete restrict,
    foreign key (cared_by_id) references employees (id) on update cascade on delete restrict,
    foreign key (room_id) references rooms (id) on update cascade on delete restrict
);