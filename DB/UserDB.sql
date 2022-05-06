create database user_db collate utf8mb4_general_ci;

use user_db;

create Table user(
	user_id int unsigned auto_increment not null,
    username varchar(100) not null unique,
    password varchar(100) not null,
    
	constraint user_id_PK primary key (user_id)
);

select * from user;
drop table user;
drop database user_db;

insert into user values(1,"David","Sesam123");