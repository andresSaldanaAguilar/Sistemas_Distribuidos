create database Ejer1;
use Ejer1;
create table Producto(
    idProducto int not null auto_increment primary key,
    nombre varchar(30) not null,
    precio double not null,
    idCategoria int not null,
    foreign key(idCategoria) references Categoria(idCategoria) on update cascade on delete cascade
);

create table Categoria(
    idCategoria int not null auto_increment primary key,
    nombre varchar(30) not null,
    descripcion varchar(30) not null
);
-- Hacer procedures para categoria similares a estos, al igual que mostrar productos por categoria
delimiter $
create procedure spInsertar(nombreProducto varchar(30), elPrecio double, idCat int)
begin
    insert into Producto(nombre,precio,idCategoria) values(nombreProducto,elPrecio,idCat);
end $

create procedure spActualizar(nombreProducto varchar(30),elPrecio double, idCat int, idProd int)
begin
    update Producto set nombre=nombreProducto, precio=elPrecio, idCategoria=idCat where idProducto=idProd;
end $

create procedure spDelete (idProd int)
begin 
    select * from Producto;
end $

create procedure spSelectOne(idProd int)
begin
    select * from Producto where idProducto=idProd;
end $

create procedure spSelectAll()
begin
    select * from Producto;
end $

delimiter ;

-- para cada tabla hacer una clase que la represente