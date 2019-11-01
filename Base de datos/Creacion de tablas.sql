create table if not exists Login(
	Correo varchar(20) not null primary key,
	Contrase_na varchar(300) not null
);

create table if not exists Usuarios(
	carnet int not null primary key,
	nobre varchar(15) not null,
	apellido varchar not null,
	carrera varchar(16)not null,
	correo varchar(20)not null,
	tiene_multas varchar(1)not null
);
--create table if not exists multas(
--	id int not null primary key,
--	carnet int(20)not null,
--	valor int(32)not null,
--	fecha date not null
--);