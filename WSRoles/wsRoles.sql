create database WSRoles;

use WSRoles;

create table Roles(
	id int not null auto_increment primary key,
	nombreRol varchar(30)
);

insert into Roles values (1, 'Administrador'), (2, 'Limitado'), (3, 'Capturista');
  
     
select * from Roles;

    

    