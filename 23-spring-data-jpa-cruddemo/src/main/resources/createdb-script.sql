Create Database if not exists employee_directory;
use employee_directory;

drop tables if exists employee;

create table employee (
id int(11) not null auto_increment,
first_name varchar(45) default null,
last_name varchar(45) default null,
email varchar(45) default null,
primary key (id)
)
engine=innoDB auto_increment=1 default charset=utf8;

