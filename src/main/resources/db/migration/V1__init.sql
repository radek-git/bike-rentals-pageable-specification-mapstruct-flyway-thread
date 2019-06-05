create table users
(
    id                     bigint primary key auto_increment,
    name                   varchar(50)        not null,
    surname                varchar(50)        not null,
    username               varchar(60) unique not null,
    password               varchar(60)        not null,
    pesel                  varchar(11) unique not null,
    balance                decimal(4, 2)     ,
    is_expired             boolean            not null default false,
    is_locked              boolean            not null default false,
    is_credentials_expired boolean            not null default false,
    is_enabled             boolean            not null default false,
    created_at             timestamp          not null,
    updated_at             timestamp          not null

);

create table bike_colors
(
    id   bigint primary key auto_increment,
    name varchar(50) unique not null
);


create table bikes
(
    id                 bigint primary key auto_increment,
    serial_number      varchar(5) unique not null,
    date_of_production date              not null,
    color_id           bigint            not null,
    is_busy            boolean           not null,
    created_at         timestamp         not null,
    updated_at         timestamp         not null,

    foreign key (color_id) references bike_colors (id)
);

create table rentals
(
    id              bigint primary key auto_increment,
    user_id         bigint      not null,
    started_at      datetime    not null,
    finished_at     datetime,
    bike_id         bigint      not null,
    start_latitude  varchar(50) not null,
    start_longitude varchar(50) not null,
    end_latitude    varchar(50),
    end_longitude   varchar(50),
    price           decimal(4, 2),

    foreign key (user_id) references users (id),
    foreign key (bike_id) references bikes (id)
);

create table bike_locations
(
    id        bigint primary key auto_increment,
    latitude  varchar(50) not null,
    longitude varchar(50) not null,
    bike_id   bigint      not null,
    rental_id bigint,
    datetime  datetime    not null,

    foreign key (bike_id) references bikes (id),
    foreign key (rental_id) references rentals (id)
);


create table pricing
(
    id    bigint primary key auto_increment,
    name  varchar(50)  unique not null,
    price decimal(4, 2) not null
);

create table bike_repairs
(
    id          bigint primary key auto_increment,
    datetime    datetime      not null,
    description varchar(200)  not null,
    cost        decimal(4, 2) not null,
    bike_id     bigint        not null,

    foreign key (bike_id) references bikes (id)
)