create table  USUARIOS(
	carnet int  primary key,
	nombre varchar(15) not null,
	apellido varchar(15) not null,
	carrera varchar(16)not null,
	correo varchar(100)not null,
	rol varchar(1) not null,
	contrasena varchar(300) not null
);

create table RECURSOS(
	identificador int primary key,
	nombre varchar(100)not null,
	ubicacion varchar(50)not null,
	capacidad int,
	horarioI time,
	horarioF time,
	disponibilidad varchar(13) not null,
	tiporecurso_id int NOT NULL
);
CREATE TABLE  TIPO_RECURSO (
	id INT primary key,
	descripcion VARCHAR(50)  NOT NULL
);
create table  reservados(
	id int primary key,
	fechaInicioReserva date not null,
	horaInicioReserva time not null,
	fechaFinReserva date not null,
	horaFinReserva time  not null,
	usuario int not null,
	recurso int not null
);


