create table rule(
    id serial primary key,
    name varchar
);
create table type(
    id serial primary key,
    name varchar
);
create table accidents(
    id serial primary key,
    name varchar,
    text varchar,
    address varchar,
    type_id int references type(id)
);
create table accidents_rule(
    id serial primary key,
    accident_id int references accidents(id),
    rule_id int references rule(id)
);

insert into type(name) values ('Две машины'),('Машина и человек'),('Машина и велосипед');
insert into rule(name) values ('Статья. 1'),('Статья. 2'),('Статья. 3');
insert into accidents(name, text, address, type_id) values ('name1', 'desc1', 'address1', 1);
insert into accidents_rule (accident_id, rule_id) values (1, 1);