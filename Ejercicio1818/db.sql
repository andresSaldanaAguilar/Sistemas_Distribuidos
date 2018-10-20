create database InventarioSimple;
use InventarioSimple;
create table Articulo(
    claveArticulo char(10) not null,
    descripcion varchar(50) not null,
    precio decimal(12,2) not null,
    existencias int not null,
    primary key(claveArticulo)
);