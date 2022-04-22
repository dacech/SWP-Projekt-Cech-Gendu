create database db_ToDoList collate utf8mb4_general_ci;

use db_ToDoList;

create Table user(
	user_id int unsigned auto_increment not null,
    username varchar(100) not null unique,
    password varchar(100) not null,
    
	constraint user_id_PK primary key (user_id)
);

select * from user;
drop table user;

 create Table appointment(
 
 appointment_id int unsigned auto_increment not null,
 appointment_date date not null,
 appointment_name varchar(100) not null unique,
 priority int null,
 note varchar(100) null,
 appointment_start time not null,
 appointment_end time not null,
 
 constraint appointment_id_PK primary key(appointment_id)
 );
 
 select * from appointment;
 drop table appointment;
 
 create table user_appointment(
 user_appointment_id int unsigned auto_increment not null,
 user_id int unsigned not null,
 appointment_id int unsigned not null,
 
 constraint user_appointment_id_PK primary key(user_appointment_id),
 constraint user_id_FK foreign key(user_id) references user(user_id),
 constraint appointment_id_FK foreign key(appointment_id) references appointment(appointment_id)
);

select * from user_appointment;
drop table user_appointment;