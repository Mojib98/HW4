create table if not exists cinema(
    id serial,
    name varchar primary key ,
    passcode INTEGER ,
    address varchar,
    active boolean default (false)
);
create table if not exists myUser(
    id serial primary key ,
    name varchar unique ,
    passcode INTEGER,
    budget INTEGER
);
-- SET TIMEZONE ='Iran/Tehran';

create table if not exists ticket(
    id serial primary key ,
    cinemaName varchar references cinema(name),
    price INTEGER,
    number Integer,
    nameMovie varchar,
    date DATE,
    time TIME
);
create table if not exists user_ticket(
    idUser INTEGER references myUser(id),
    idTicket INTEGER references ticket(id),
    number integer
);
ALTER TABLE ticket ADD COLUMN movieName varchar;
ALTER TABLE cinema ADD COLUMN budget INTEGER;
