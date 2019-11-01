create table if not exists Login(
	correo varchar(20) not null primary key,
	contrasena varchar(300) not null
);

create table if not exists Usuarios(
	carnet int not null primary key,
	nobre varchar(15) not null,
	apellido varchar not null,
	carrera varchar(16)not null,
	correo varchar(20)not null
);

create table if not exists Recursos(
	identificador int primary key,
	nombre varchar(15)not null,
	ubicacion varchar(15)not null,
	tipo varchar(10)not null,
	capacidad int,
	horario_disponibilidad date,
	diponibilidad varchar(1) not null
);
--create table if not exists multas(
--	id int not null primary key,
--	carnet int(20)not null,
--	valor int(32)not null,
--	fecha date not null
--);
drop table Usuarios;
drop table login;
