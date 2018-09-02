create database Banco;
use Banco;

create table Clientes(
    idClientes int(10) not null auto_increment primary key,
    contrasenia varchar(10) not null,
    nombre varchar(30) not null,
    apellidoPaterno varchar(30) not null,
    apellidoMaterno varchar(30) not null,
    numeroTelefonico varchar(30) not null,
    calle varchar(30) not null,
    colonia varchar(30) not null,
    numero int(10) not null
);

create table Cuenta(
    idCuenta bigint(20) not null auto_increment primary key,
    balance double not null,
    idClientes int(10) not null,
    foreign key(idClientes) references Clientes(idClientes) on update cascade on delete cascade
);

create table operacionesCuenta(
    idOperacionesCuenta bigint(20) not null auto_increment primary key,
    fechaOperacion datetime not null,
    tipoDeMovimiento varchar(1) not null,
    cantidad double not null,
    idCuenta bigint(20) not null,
    foreign key(idCuenta) references Cuenta(idCuenta) on update cascade on delete cascade
);

delimiter $


create procedure spInsertarCliente(contra varchar(10), nom varchar(30), apellidoPat varchar(30), apellidoMat varchar(30), numTelefonico varchar(30), cashe varchar(10), col varchar(30), num int(10))
begin
    insert into Clientes(contrasenia,nombre,apellidoPaterno,apellidoMaterno,numeroTelefonico,calle,colonia,numero) values(contra, nomb, apellidoPat, apellidoMat , numTelefonico, cashe, col, num);
end $

create procedure spActualizarCliente(contra varchar(10), nom varchar(30), apellidoPat varchar(30), apellidoMat varchar(30), numTelefonico varchar(30), cashe varchar(10), col varchar(30), num int(10), idClient int(10))
begin
    update Clientes set contrasenia=contra, nombre=nom, apellidoPaterno=apellidoPat, apellidoMaterno=apellidoMat, numeroTelefonico=numTelefonico, calle=cashe, colonia=col, numero=num where idClientes=idClient;
end $

create procedure spDeleteCliente(idClient int)
begin 
    delete from Clientes where idClientes = idClient;
end $

create procedure spSelectOneCliente(contra varchar(10), nom varchar(10))
begin
    select * from Clientes where contrasenia=contra and nombre=nom;
end $

create procedure spInsertaroperacionesCuenta( tipoDeMov varchar(1), cant double, idCuent bigint(20) )
begin
    insert into operacionesCuenta(fechaOperacion,tipoDeMovimiento,cantidad,idCuenta) values(CURRENT_TIMESTAMP(),tipoDeMov,cant,idCuent);
end $

create procedure spActualizaroperacionesCuenta( fechaOper date, tipoDeMov varchar(1), cant double, idCuent bigint(20), idOp bigint(20) )
begin
    update operacionesCuenta set fechaOperacion=fechaOper, tipoDeMovimiento=tipoDeMov, cantidad=cant, idCuenta=idCuent where spInsertaroperacionesCuenta=idOp;
end $

create procedure spDeleteoperacionesCuenta(idOp bigint(20))
begin 
    delete from operacionesCuenta where spInsertaroperacionesCuenta=idOp;
end $

create procedure spSelectOperacionesCuenta(idCuent bigint(20))
begin
    select fechaOperacion,tipoDeMovimiento,cantidad from operacionesCuenta where idCuenta=idCuent;
end $

create procedure spSelectAlloperacionesCuenta()
begin
    select * from operacionesCuenta;
end $

create procedure spActualizarCuenta(balanc double , idClient int(20))
begin
    update Cuenta set balance=balanc where idClientes=idClient;
end $

create procedure spSelectOneCuenta(idClient int(10))
begin
    select * from Cuenta where idClientes=idClient;
end $

delimiter ;
