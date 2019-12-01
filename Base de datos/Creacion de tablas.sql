create table if not exists USUARIOS(
	carnet int  primary key,
	nombre varchar(15) not null,
	apellido varchar(15) not null,
	carrera varchar(16)not null,
	correo varchar(100)not null,
	rol varchar(1) not null,
	contrasena varchar(300) not null
);

create table if not exists RECURSOS(
	identificador  Serial primary key,
	nombre varchar(100)not null,
	ubicacion varchar(50)not null,
	capacidad int,
	horarioI time,
	horarioF time,
	disponibilidad varchar(13) not null,
	descripcion varchar(360),
	tiporecurso_id int NOT NULL
);


CREATE table if not exists TIPO_RECURSO (
	id serial primary key,
	descripcion VARCHAR(50)  NOT NULL
);

create table if not exists reservados(
	idr serial primary key,
	fechaInicioReserva date not null,
	horaInicioReserva time not null,
	fechaFinReserva date not null,
	horaFinReserva time  not null,
	recurrente varchar(2),
	estado varchar(9),
	fechaDeReserva date,
	usuario int not null,
	recurso int not null
);


